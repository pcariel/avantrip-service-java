package io.avantrip.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.avantrip.binding.FlightCreateRequest;
import io.avantrip.binding.RuleCreateRequest;
import io.avantrip.binding.RuleUpdateRequest;
import io.avantrip.domain.RuleEntity;
import io.avantrip.model.Rule;
import io.avantrip.repository.RuleRepository;

@Service
@Transactional
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private CardService cardService;

    @Override
    public Rule createRule(RuleCreateRequest request) {
        RuleEntity ruleEntity = ruleRepository.saveAndFlush(new RuleEntity(request.getName(), request.getDescription(),
                request.getConditions(), request.getActions(), request.getScored(), request.getActive()));
        return new Rule().fromEntity(ruleEntity);
    }

    @Override
    public Optional<Rule> getRule(final Long id) {
        return Optional.ofNullable(ruleRepository.findOne(id)).map(a -> new Rule().fromEntity(a));
    }

    @Override
    public Page<Rule> getRules(Pageable pageable) {
        Page<RuleEntity> rules = ruleRepository.findAll(pageable);
        Page<Rule> pageRules = rules.map(new Converter<RuleEntity, Rule>() {
            @Override
            public Rule convert(final RuleEntity ruleEntity) {
                return new Rule().fromEntity(ruleEntity);
            }
        });
        return pageRules;
    }

    @Override
    public void deleteRule(Long id) {
        ruleRepository.delete(id);
    }

    @Override
    public Rule updateRule(final Long idRule, final RuleUpdateRequest request) {
        final RuleEntity ruleEntity = ruleRepository.getOne(idRule);
        ruleEntity.setName(request.getName());
        ruleEntity.setDescription(request.getDescription());
        ruleEntity.setConditions(request.getConditions());
        ruleEntity.setActions(request.getActions());

        return new Rule().fromEntity(ruleRepository.save(ruleEntity));
    }

    @Override
    public Boolean validate(FlightCreateRequest request) {
        List<RuleEntity> rulesAvantrip = ruleRepository.findByActiveTrue();
        Stream<RuleEntity> rulesAvantripStream = rulesAvantrip.stream();

        Facts fact = new Facts();
        fact.put("scoring", 0);
        fact.put("cardNumber", request.getPayment().getNumber());
        fact.put("countryName", request.getTrip().getDestiny());
        
        Rules rules = new Rules();

        rulesAvantripStream.forEach(a -> {
            RuleBuilder ruleBuilder = new RuleBuilder().name(a.getName()).description(a.getDescription());

            switch (a.getName()) {
            case "blackListCard":
                ruleBuilder.when(facts -> cardService.isBlackList(facts.get("cardNumber")))
                        .then(facts -> calculateScoring(fact, a.getScored()));
                rules.register(ruleBuilder.build());
                break;
            case "blackListCuntry":
                ruleBuilder.when(facts -> cardService.isBlackList(facts.get("countryName")))
                        .then(facts -> calculateScoring(fact, a.getScored()));
                rules.register(ruleBuilder.build());
                break;
            default:
                rules.register(new MVELRule().name(a.getName()).description(a.getDescription()).when(a.getConditions())
                        .then(a.getActions()));
                break;
            }

        });
        final Integer scoredResult = fact.get("scoring");
        if (scoredResult > request.getScoring()) return true;
        return false;
    }

    private void calculateScoring(Facts facts, Integer result) {
        Integer value = facts.get("scoring");
        value += result;
        facts.put("scoring", value);
    }
}