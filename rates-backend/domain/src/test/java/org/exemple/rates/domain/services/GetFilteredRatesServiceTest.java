package org.exemple.rates.domain.services;

import org.exemple.rates.domain.model.CurrencyFormat;
import org.exemple.rates.domain.model.Rate;
import org.exemple.rates.domain.model.RateCriteria;
import org.exemple.rates.domain.ports.out.CurrencyClientPort;
import org.exemple.rates.domain.ports.out.RatePersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetFilteredRatesServiceTest {

    @Mock
    private RatePersistencePort ratePersistencePort;

    @Mock
    private CurrencyClientPort currencyClientPort;

    @InjectMocks
    private GetFilteredRatesService getFilteredRatesService;

    /**
     * GIVEN
     * WHEN
     * THEN
     */
    @Test
    void testFormattedPriceForOnlyOneEuroRateAndFormatWith3Decimals() {
        // Arrange
        RateCriteria rateCriteria = new RateCriteria();
        rateCriteria.setProductId(1L);
        rateCriteria.setBrandId(1L);
        rateCriteria.setDate(LocalDate.now());

        // dummy rate and mock
        Rate rate = new Rate();
        rate.setCurrencyCode("EUR");
        rate.setPrice(1550D);

        List<Rate> ratesMock = new ArrayList<>();
        ratesMock.add(rate);

        when(ratePersistencePort.getRatesByFilter(eq(rateCriteria))).thenReturn(ratesMock);

        // Mock currencyClientPort.getAllCurrencyFormat
        mockCurrencyClientPortGetAllCurrencyFormats();

        // Act
        List<Rate> rates = getFilteredRatesService.getFilteredRates(rateCriteria);

        // Assert
        assertEquals("1.550,000 €", rates.get(0).getFormattedPrice());
    }

    /**
     * Mock currencyClientPort.getAllCurrencyFormat
     * Default values:
     * - code: EUR, Decimal: 3
     * - code: USD, Decimal: 2
     */
    private void mockCurrencyClientPortGetAllCurrencyFormats() {
        // dummy currencyClientPort
        CurrencyFormat currencyFormatEuro = new CurrencyFormat();
        currencyFormatEuro.setCode("EUR");
        currencyFormatEuro.setDecimals(3);

        CurrencyFormat currencyFormatDolar = new CurrencyFormat();
        currencyFormatDolar.setCode("USD");
        currencyFormatDolar.setDecimals(2);

        List<CurrencyFormat> currencyFormats = Arrays.asList(currencyFormatEuro, currencyFormatDolar);
        when(currencyClientPort.getAllCurrencyFormat()).thenReturn(currencyFormats);
    }
}