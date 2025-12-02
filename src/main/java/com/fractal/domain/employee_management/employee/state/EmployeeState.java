package com.fractal.domain.employee_management.employee.state;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.order.Order;
import com.fractal.domain.state.EntityState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employee_state", schema = "state_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeState extends EntityState {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
}
