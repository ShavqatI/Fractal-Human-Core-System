package com.fractal.domain.employee_management.address.mapper;

import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;

public interface EmployeeAddressMapperService {
    EmployeeAddressResponse toDTO(EmployeeAddress address);
    EmployeeAddress toEntity(EmployeeAddressRequest dto);
    EmployeeAddress toEntity(EmployeeAddress address, EmployeeAddressRequest dto);
}


