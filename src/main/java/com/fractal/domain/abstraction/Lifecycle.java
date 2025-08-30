package com.fractal.domain.abstraction;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Lifecycle extends AbstractEntity {

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "open_reason")
    private String openReason;

    @Column(name = "close_date")
    private LocalDate closeDate;

    @Column(name = "close_reason")
    private String closeReason;
}
