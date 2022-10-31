package org.example.rates.application.controller;

import org.exemple.rates.domain.model.Rate;
import org.exemple.rates.domain.model.RateCriteria;
import org.exemple.rates.domain.ports.in.GetFilteredRatesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rates")
public class RateController {

    @Autowired
    private GetFilteredRatesUseCase RateServicePort;

    @GetMapping
    public List<Rate> GetFilteredRates(@RequestParam("date")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                       @RequestParam("brandId") Long brandId,
                                       @RequestParam("productId") Long productId
    ) {

        RateCriteria rateCriteria = new RateCriteria();
        rateCriteria.setBrandId(brandId);
        rateCriteria.setProductId(productId);
        rateCriteria.setDate(date);

        return RateServicePort.getFilteredRates(rateCriteria);
    }
}