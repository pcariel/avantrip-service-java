package io.avantrip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.avantrip.binding.CountryCreateRequest;
import io.avantrip.model.Country;
import io.avantrip.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/countries")
@Api(value = "Avantrip - Country", description = "Country Service")
public class CountryController {
    private final Logger log = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @PostMapping
    @ApiOperation(value = "resource for new black list country", notes = "")
    public Country createRule(@RequestBody CountryCreateRequest requestJson) {

        log.info("Request -> createBlackList -> Body -> {}", requestJson);
        return countryService.addBlackList(requestJson);
    }

    @GetMapping
    @ApiOperation(value = "resource for get all black list country by Page", notes = "")
    public ResponseEntity<Page<Country>> getRules(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
        
        log.info("Request -> getBlackListCard");
        Page<Country> pages = countryService.getAll(new PageRequest(pageNumber, pageSize));
        return ResponseEntity.ok(pages);
    }
}