package com.fractal.domain.system.environment_variable;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "environment_variable", schema = "system_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentVariable extends Dictionary {

    @Column(name = "value")
    private String value;

}
