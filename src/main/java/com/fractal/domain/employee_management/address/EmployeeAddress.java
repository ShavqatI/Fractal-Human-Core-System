package com.fractal.domain.employee_management.address;


import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.location.address.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_address", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddress extends Address {

    @ManyToOne
    @JoinColumn(name ="employee_id", referencedColumnName = "id")
    private Employee employee;
}
