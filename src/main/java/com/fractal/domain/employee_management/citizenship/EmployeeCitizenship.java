package com.fractal.domain.employee_management.citizenship;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.citizenship.Citizenship;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.location.country.Country;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employee_citizenship", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeCitizenship extends Citizenship {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
