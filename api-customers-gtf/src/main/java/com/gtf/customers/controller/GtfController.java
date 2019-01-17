package com.gtf.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gtf.customers.models.GtfResponse;
import com.gtf.customers.service.GtfService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class GtfController {

    @Autowired
    GtfService service;

    // @GetMapping(value = "/", produces = "text/plain; charset=utf-8")
    @GetMapping(value = "/", produces = "application/json")
    @ApiResponses(
        value = {@ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "customer not found."),
            @ApiResponse(code = 500, message = "Unexpected error.")})
    public ResponseEntity<List<GtfResponse>> execute(
        @RequestParam(required = false) String customerId,
        @RequestParam(required = false) String documentNumber,
        @RequestParam(required = false) String companyName,
        @RequestParam(required = false) String accountNumber,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String paternalName,
        @RequestParam(required = false) String matternalName,
        @RequestHeader String accept,
        @RequestHeader String acceptLanguage,
        @RequestHeader String contentType,
        @RequestHeader String xIbmClientId,
        @RequestHeader String authorization,
        @RequestHeader String xSantanderGlobalId) {

        try {

            return service.execute(customerId).isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(service.execute(customerId),
                    HttpStatus.OK);

        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
