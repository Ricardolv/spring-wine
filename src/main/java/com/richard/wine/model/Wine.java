package com.richard.wine.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "code")
@Entity
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @NotBlank
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeWine type;

    @NotNull
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal value;
}
