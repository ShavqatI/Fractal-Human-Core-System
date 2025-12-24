package com.fractal.domain.profile.address;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.EmployeeAddressService;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileAddressServiceImpl implements ProfileAddressService {

   private final EmployeeAddressService addressService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeAddress> getAll() {
        return addressService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeAddress getById(Long id) {
        return getAll().stream()
                .filter(address -> address.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public EmployeeAddressResponse toDTO(EmployeeAddress address) {
        return addressService.toDTO(address);
    }


}
