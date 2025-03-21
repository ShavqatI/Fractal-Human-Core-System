package com.fractal.domain.abstraction;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Location extends AbstractEntity {

    @Column(name = "name")
    protected String name;

    @Column(name = "code", unique = true, length = 5)
    protected String code;
}
