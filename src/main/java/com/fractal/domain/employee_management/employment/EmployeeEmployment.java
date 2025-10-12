package com.fractal.domain.employee_management.employment;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.Employment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "employee_employment", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class EmployeeEmployment extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="employment_id", referencedColumnName = "id")
    private Employment employment;
}
