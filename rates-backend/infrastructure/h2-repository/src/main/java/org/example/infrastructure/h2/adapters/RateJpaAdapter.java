package org.example.infrastructure.h2.adapters;

import org.example.infrastructure.h2.entity.RateEntity;
import org.example.infrastructure.h2.mappers.RateMapper;
import org.example.infrastructure.h2.repository.RateRepository;
import org.exemple.rates.domain.model.Rate;
import org.exemple.rates.domain.model.RateCriteria;
import org.exemple.rates.domain.ports.out.RatePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateJpaAdapter implements RatePersistencePort {

    @Autowired
    private RateRepository rateRepository;

    public List<Rate> getRatesByFilter(RateCriteria rateCriteria) {
        List<RateEntity> rateEntities = rateRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThan(rateCriteria.getBrandId(), rateCriteria.getProductId(), rateCriteria.getDate(), rateCriteria.getDate());

        return RateMapper.INSTANCE.rateListToRateDtoList(rateEntities);
    }
}