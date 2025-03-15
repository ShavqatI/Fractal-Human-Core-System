package com.fractal.domain.abstraction;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Dictionary extends AbstractEntity {

    @Column(name = "code",unique = true)
    private String code;

    @Column(name = "name")
    private String name;

}
