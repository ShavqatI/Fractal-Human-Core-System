package com.fractal.domain.employee_management.address;

import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;

public interface EmployeeAddressService {

    EmployeeAddressResponse toDTO(EmployeeAddress address);
    EmployeeAddress toEntity(EmployeeAddressRequest dto);
    EmployeeAddress update(EmployeeAddress address,EmployeeAddressRequest dto);
    void delete(EmployeeAddress address);
}
