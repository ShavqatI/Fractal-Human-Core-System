package com.fractal.domain.location.address;


import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.location.address.type.AddressType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_address", schema = "location_schema", catalog = "fractal")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddress extends Address {

    @ManyToOne
    @JoinColumn(name ="employee_id", referencedColumnName = "id")
    private Employee employee;
}
