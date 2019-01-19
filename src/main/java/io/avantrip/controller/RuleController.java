package io.avantrip.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.avantrip.binding.RuleCreateRequest;
import io.avantrip.binding.RuleUpdateRequest;
import io.avantrip.model.Rule;
import io.avantrip.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/rules")
@Api(value = "Avantrip - Rules", description = "Rules Service")
public class RuleController {
    private final Logger log = LoggerFactory.getLogger(RuleController.class);

    @Autowired
    private RuleService ruleService;
    
    @PostMapping
    @ApiOperation(value = "resource for new rule", notes = "")
    public Rule createRule(@RequestBody RuleCreateRequest requestJson) {

        log.info("Request -> createRule -> Body -> {}", requestJson);
        return ruleService.createRule(requestJson);
    }

    @GetMapping
    @ApiOperation(value = "resource for get all rule by Page", notes = "")
    public ResponseEntity<Page<Rule>> getRules(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
        
        log.info("Request -> getRules");
        Page<Rule> pages = ruleService.getRules(new PageRequest(pageNumber, pageSize));
        return ResponseEntity.ok(pages);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "resource for get rule by id", notes = "")
    public ResponseEntity<Rule> getRule(@PathVariable() final Long id) {
        
        log.info("Request -> getRule id: {}", id);
        Optional<Rule> rule = ruleService.getRule(id);
        
        if (!rule.isPresent())
            ResponseEntity.notFound();
        return ResponseEntity.ok(rule.get());
        
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "resource for update rule by id", notes = "")
    public Rule updateRule(@PathVariable() final Long id, @RequestBody RuleUpdateRequest requestJson) {
        log.info("Request -> updateRule id: {} Boby -> {}", id, requestJson);
        return ruleService.updateRule(id, requestJson);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "resource for delete rule by id", notes = "")
    public ResponseEntity<String> deleteRule(@PathVariable() final Long id) {
        
        log.info("Request -> deleteRule id: {}", id);
        ruleService.deleteRule(id);
        return ResponseEntity.ok("");
    }
}