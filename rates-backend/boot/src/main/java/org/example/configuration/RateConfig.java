package org.example.configuration;

import org.example.infrastructure.api.client.currency.adapters.ApiCurrencyClientAdapter;
import org.example.infrastructure.h2.adapters.RateJpaAdapter;
import org.exemple.rates.domain.ports.in.GetFilteredRatesUseCase;
import org.exemple.rates.domain.ports.out.CurrencyClientPort;
import org.exemple.rates.domain.ports.out.RatePersistencePort;
import org.exemple.rates.domain.services.GetFilteredRatesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateConfig {

    @Bean
    public RatePersistencePort ratePersistence() {
        return new RateJpaAdapter();
    }

    @Bean
    public CurrencyClientPort currencyClientPort() {
        return new ApiCurrencyClientAdapter();
    }

    @Bean
    public GetFilteredRatesUseCase rateService() {
        return new GetFilteredRatesService(ratePersistence(), currencyClientPort());
    }
}