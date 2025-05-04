package com.fractal.domain.location;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
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
