package com.fractal.domain.employee_management.employment.state;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.state.EntityState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employee_employment_state", schema = "state_schema", catalog = "fractal")
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEmploymentState extends EntityState {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_employment_id", referencedColumnName = "id")
    private EmployeeEmployment employeeEmployment;
}
