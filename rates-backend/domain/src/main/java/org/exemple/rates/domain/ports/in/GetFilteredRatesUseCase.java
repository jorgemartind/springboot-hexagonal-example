package org.exemple.rates.domain.ports.in;

import org.exemple.rates.domain.model.Rate;
import org.exemple.rates.domain.model.RateCriteria;

import java.util.List;

public interface GetFilteredRatesUseCase {
    List<Rate> getFilteredRates(RateCriteria rateCriteria);
}