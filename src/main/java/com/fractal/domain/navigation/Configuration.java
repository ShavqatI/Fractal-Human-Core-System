package com.fractal.domain.navigation;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "configuration", schema = "navigation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class Configuration extends AbstractEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
}
