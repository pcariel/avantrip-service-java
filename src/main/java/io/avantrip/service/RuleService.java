package io.avantrip.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.avantrip.binding.FlightCreateRequest;
import io.avantrip.binding.RuleCreateRequest;
import io.avantrip.binding.RuleUpdateRequest;
import io.avantrip.model.Rule;

@Service
public interface RuleService {
    Rule createRule(final RuleCreateRequest request);
    Optional<Rule> getRule(final Long id);
    Page<Rule> getRules(final Pageable pageable);
    void deleteRule(final Long id);
    Rule updateRule(final Long idRule, final RuleUpdateRequest request);
    Boolean validate(final FlightCreateRequest requestJson);
}