package io.avantrip.service;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.avantrip.builders.RuleEntityBuilder;
import io.avantrip.domain.RuleEntity;
import io.avantrip.repository.RuleRepository;

@ActiveProfiles(value = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class RuleServiceTests {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private RuleRepository ruleRepository;

    private RuleEntity rule;
    @Before
    public void setup() {
        //RuleEntityBuilder ruleEntityBuilder = new RuleEntityBuilder();
        //this.rule = ruleRepository.save(ruleEntityBuilder.build());
    }

    @Test
    public void successfullyRegisterRule() {
        RuleEntity rule = new RuleEntityBuilder()
            .withName("Test Rule - Avantrip")
            .withDescription("description")
            .withActions("actions")
            .withScored(100)
            .withActive(true)
            .withConditions("conditions").build();

        RuleEntity ruleEntity = ruleRepository.save(rule);

        assertEquals(rule.getName(), ruleEntity.getName());
    }
}