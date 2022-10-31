package org.example.infrastructure.api.client.currency.adapters;

import org.exemple.rates.domain.model.CurrencyFormat;
import org.exemple.rates.domain.ports.out.CurrencyClientPort;

import java.util.Arrays;
import java.util.List;

public class ApiCurrencyClientAdapter implements CurrencyClientPort {
    @Override
    public List<CurrencyFormat> getAllCurrencyFormat() {
        // TODO replace mock to call web service / api endpoint
        CurrencyFormat currencyFormatEuro = new CurrencyFormat();
        currencyFormatEuro.setCode("EUR");
        currencyFormatEuro.setDecimals(2);

        CurrencyFormat currencyFormatDolar = new CurrencyFormat();
        currencyFormatDolar.setCode("USD");
        currencyFormatDolar.setDecimals(3);

        return Arrays.asList(currencyFormatEuro, currencyFormatDolar);
    }

    @Override
    public CurrencyFormat getCurrencyFormatByCurrencyIsoCode(String currencyIsoCode) {
        // TODO replace mock to call web service / api endpoint
        CurrencyFormat currencyFormat = new CurrencyFormat();
        currencyFormat.setCode(currencyIsoCode);
        currencyFormat.setDecimals(2);
        return currencyFormat;
    }
}