package com.fractal.domain.employee_management.address;

import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;

import java.util.List;

public interface EmployeeAddressService {
    EmployeeAddress create(Long employeeId, EmployeeAddressRequest dto);
    EmployeeAddress getById(Long employeeId,Long id);
    List<EmployeeAddress> getAllByEmployeeId(Long employeeId);
    EmployeeAddress update(Long employeeId,Long id, EmployeeAddressRequest dto);
    void delete(Long employeeId, Long id);
    EmployeeAddressResponse toResponse(EmployeeAddress address);

}
