package com.fractal.domain.abstraction;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Dictionary extends AbstractEntity {

    @Column(name = "code", unique = true)
    protected String code;

    @Column(name = "name")
    protected String name;
}
