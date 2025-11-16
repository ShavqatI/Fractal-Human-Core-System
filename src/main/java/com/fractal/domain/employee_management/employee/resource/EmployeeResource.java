package com.fractal.domain.employee_management.employee.resource;


import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.resource.type.EmployeeResourceType;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employee_resource", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeResource extends Resource {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_resource_type_id", referencedColumnName = "id")
    private EmployeeResourceType employeeResourceType;
}
