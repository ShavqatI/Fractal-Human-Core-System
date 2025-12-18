package com.fractal.domain.profile.address;

import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;

import java.util.List;

public interface ProfileAddressService {
    List<EmployeeAddress> getAll();


    EmployeeAddress getById(Long id);

    EmployeeAddressResponse toDTO(EmployeeAddress address);


}
