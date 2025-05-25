package com.fractal.domain.employee_management.employment.type;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "category", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmploymentType extends Dictionary {

}
