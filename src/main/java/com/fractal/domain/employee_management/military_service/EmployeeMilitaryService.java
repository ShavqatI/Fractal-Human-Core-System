package com.fractal.domain.employee_management.military_service;


import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.military_service.MilitaryService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "employee_military_service", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMilitaryService extends MilitaryService {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
