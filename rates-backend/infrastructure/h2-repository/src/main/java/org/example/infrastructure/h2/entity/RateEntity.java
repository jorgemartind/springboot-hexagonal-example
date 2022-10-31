package org.example.infrastructure.h2.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "T_RATES")
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private Long productId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String currencyCode;
}