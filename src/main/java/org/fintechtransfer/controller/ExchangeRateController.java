package org.fintechtransfer.controller;

import org.fintechtransfer.dto.ExchangeRateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {
    private ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public ResponseEntity<List<ExchangeRateDto>> list(String){}
}
