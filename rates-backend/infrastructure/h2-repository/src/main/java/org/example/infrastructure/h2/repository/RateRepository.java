package org.example.infrastructure.h2.repository;

import org.example.infrastructure.h2.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {

    List<RateEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThan(Long brandId, Long productId, LocalDate startDate, LocalDate endDate);

}