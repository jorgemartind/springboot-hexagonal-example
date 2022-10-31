package org.exemple.rates.domain.services;

import org.exemple.rates.domain.model.CurrencyFormat;
import org.exemple.rates.domain.model.Rate;
import org.exemple.rates.domain.model.RateCriteria;
import org.exemple.rates.domain.ports.in.GetFilteredRatesUseCase;
import org.exemple.rates.domain.ports.out.CurrencyClientPort;
import org.exemple.rates.domain.ports.out.RatePersistencePort;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class GetFilteredRatesService implements GetFilteredRatesUseCase {

    private RatePersistencePort ratePersistencePort;
    private CurrencyClientPort currencyClientPort;

    public GetFilteredRatesService(RatePersistencePort ratePersistencePort, CurrencyClientPort currencyClientPort) {
        this.ratePersistencePort = ratePersistencePort;
        this.currencyClientPort = currencyClientPort;
    }

    @Override
    public List<Rate> getFilteredRates(RateCriteria rateCriteria) {
        // retrieve rates by filter
        List<Rate> rates = ratePersistencePort.getRatesByFilter(rateCriteria);

        if (rates.size() == 0) {
            return rates;
        }

        // KEY currency iso code, VALUE number of decimals
        Map<String, Integer> decimalsByCurrencyIsoCode = getDecimalsByCurrencyIsoCode(rates);

        rates.forEach(rate -> {
            addFormattedPrice(decimalsByCurrencyIsoCode, rate);
        });

        return rates;
    }

    /**
     * TODO DOC
     * @param decimalsByCurrencyIsoCode
     * @param rate
     */
    private void addFormattedPrice(Map<String, Integer> decimalsByCurrencyIsoCode, Rate rate) {
        // TODO
        //  change default locale to locale user
        // format price string
        NumberFormat priceNumberFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        // set currency iso code
        Currency currency = Currency.getInstance(rate.getCurrencyCode());
        priceNumberFormat.setCurrency(currency);

        // set decimals
        Integer decimals = decimalsByCurrencyIsoCode.get(rate.getCurrencyCode());
        priceNumberFormat.setMinimumFractionDigits(decimals);

        String formattedPrice = priceNumberFormat.format(rate.getPrice());
        rate.setFormattedPrice(formattedPrice);
    }

    /**
     * TODO complete
     * @param rates
     * @return
     */
    private Map<String, Integer> getDecimalsByCurrencyIsoCode(List<Rate> rates) {
        // get distinct currency codes to retrieve format price decimals
        List<String> rateCurrencyCodes = rates.stream()
                .map(Rate::getCurrencyCode)
                .distinct()
                .collect(Collectors.toList());

        // TODO
        //  performance improvement, if one currency code -> call specific method

        // get currency codes to format price
        List<CurrencyFormat> currencyFormats = currencyClientPort.getAllCurrencyFormat();

        return currencyFormats.stream()
                .filter(e -> rateCurrencyCodes.contains(e.getCode()))
                .collect(Collectors.toMap(CurrencyFormat::getCode, CurrencyFormat::getDecimals));
    }
}