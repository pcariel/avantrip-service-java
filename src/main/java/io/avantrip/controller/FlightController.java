package io.avantrip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/flight")
@Api(value = "Avantrip - Flight", description = "Fraudulent Service")
public class FlightController {
    private final Logger log = LoggerFactory.getLogger(FlightController.class);

}