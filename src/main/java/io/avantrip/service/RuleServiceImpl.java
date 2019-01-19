package io.avantrip.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Rule createRule(RuleCreateRequest request) {
        RuleEntity ruleEntity = ruleRepository.saveAndFlush(new RuleEntity(
            request.getName(), 
            request.getDescription(), 
            request.getConditions(), 
            request.getActions(),
            request.getScored(),
            request.getActive()));
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

}