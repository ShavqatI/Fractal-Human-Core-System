package com.fractal.domain.employee_management.address;

import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/*
@Service
@RequiredArgsConstructor
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private final EmployeeService employeeService;
    private final EmployeeAddressDomainService addressDomainService;
    @Transactional
    public EmployeeAddress addAddress(Long id, EmployeeAddressRequest dto) {
        var employee = employeeService.getById(id);
        EmployeeAddress address = addressDomainService.toEntity(dto);
        employee.addAddress(address);
        employeeService.save(employee);
        return address;
    }


    @Override
    @Transactional
    public EmployeeAddress updateAddress(Long id, Long addressId, EmployeeAddressRequest dto) {
        var employee = employeeService.getById(id);
        var address = employee.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee address with id: " + addressId + " not found"));
        address = addressDomainService.update(address,dto);
        employeeService.save(employee);
        return address;
    }

    @Override
    @Transactional
    public void deleteAddress(Long id, Long addressId) {
        var employee = employeeService.getById(id);
        var address = employee.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee address with id: " + addressId + " not found"));
        employee.removeAddress(address);
        addressDomainService.delete(address);
    }

    @Override
    public EmployeeAddressResponse toDTO(EmployeeAddress address) {
        return addressDomainService.toDTO(address);
    }
}
*/
