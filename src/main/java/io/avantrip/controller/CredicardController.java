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

import io.avantrip.binding.BlackListCreateRequest;
import io.avantrip.model.BlackListCard;
import io.avantrip.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/Credicards")
@Api(value = "Avantrip - Credicard", description = "Credicard Service")
public class CredicardController {
    private final Logger log = LoggerFactory.getLogger(CredicardController.class);

    @Autowired
    private CardService cardService;

    @PostMapping
    @ApiOperation(value = "resource for new black list card", notes = "")
    public BlackListCard createRule(@RequestBody BlackListCreateRequest requestJson) {

        log.info("Request -> createBlackList -> Body -> {}", requestJson);
        return cardService.addBlackList(requestJson.getNumber());
    }

    @GetMapping
    @ApiOperation(value = "resource for get all black list card by Page", notes = "")
    public ResponseEntity<Page<BlackListCard>> getRules(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
        
        log.info("Request -> getBlackListCard");
        Page<BlackListCard> pages = cardService.getAll(new PageRequest(pageNumber, pageSize));
        return ResponseEntity.ok(pages);
    }
}