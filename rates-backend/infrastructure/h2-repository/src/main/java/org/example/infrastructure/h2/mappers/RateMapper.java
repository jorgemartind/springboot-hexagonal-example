package org.example.infrastructure.h2.mappers;

import org.example.infrastructure.h2.entity.RateEntity;
import org.exemple.rates.domain.model.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RateMapper {
    RateMapper INSTANCE = Mappers.getMapper(RateMapper.class);

    Rate rateToRateDto(RateEntity rateEntity);

    RateEntity rateDtoToRate(Rate rate);

    List<Rate> rateListToRateDtoList(List<RateEntity> rateEntityList);

    List<RateEntity> RateDtoListToRateList(List<Rate> rateList);
}