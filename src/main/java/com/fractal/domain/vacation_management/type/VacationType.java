package com.fractal.domain.vacation_management.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "vacation_type", schema = "vacation_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VacationType extends Dictionary {
    private String description;
    private Integer days;
    private Boolean payable;
    private Integer orderOfUtilization;
}
