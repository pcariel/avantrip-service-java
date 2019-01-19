package io.avantrip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.avantrip.binding.FlightCreateRequest;
import io.avantrip.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/flight")
@Api(value = "Avantrip - Flight", description = "Fraudulent Service")
public class FlightController {
    private final Logger log = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private RuleService ruleService;

    @PostMapping("/fraudulent")
    @ApiOperation(value = "resource for detected Fraudulent", notes = "")
    public ResponseEntity<String> detectedFraudulent(@RequestBody FlightCreateRequest requestJson) {
        log.info("Request -> detectedFraudulent -> Body -> {}", requestJson);
        Boolean result = ruleService.validate(requestJson);
        if (result) return ResponseEntity.ok("TRUE");
        return ResponseEntity.ok("FALSE");
    }
}