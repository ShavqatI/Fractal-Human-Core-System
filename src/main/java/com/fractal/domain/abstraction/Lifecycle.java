package com.fractal.domain.abstraction;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public abstract class Lifecycle extends AbstractEntity {

    @Column(name = "open_date")
    protected LocalDate openDate;

    @Column(name = "open_reason")
    protected String openReason;

    @Column(name = "close_date")
    protected LocalDate closeDate;

    @Column(name = "close_reason")
    protected String closeReason;
}
