package com.fractal.domain.abstraction;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public abstract class Location extends AbstractEntity {

    @Column(name = "name")
    protected String name;

    @Column(name = "code", unique = true)
    protected String code;
}
