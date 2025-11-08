package com.fractal.domain.integration.mapping.employee;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.abstraction.Integration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employee_mapping", schema = "integration_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class EmployeeMapping extends Integration {

}
