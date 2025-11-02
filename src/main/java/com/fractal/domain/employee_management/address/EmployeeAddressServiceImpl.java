package com.fractal.domain.employee_management.address;

import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.address.mapper.EmployeeAddressMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private final EmployeeService employeeService;
    private final EmployeeAddressMapperService addressMapperService;
    private final EmployeeAddressRepository employeeAddressRepository;

    @Override
    @Transactional
    public EmployeeAddress create(Long employeeId, EmployeeAddressRequest dto) {
        var employee = employeeService.getById(employeeId);
        EmployeeAddress address = addressMapperService.toEntity(dto);
        employee.addAddress(address);
        employeeService.save(employee);
        return address;
    }

    @Override
    public List<EmployeeAddress> getAllByEmployeeId(Long employeeId) {
        return employeeAddressRepository.findAllByEmployeeId(employeeId);
    }
    @Override
    public EmployeeAddress getById(Long employeeId,Long id) {
        var employee = employeeService.getById(employeeId);
        return employee.getAddresses().stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee address with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmployeeAddress update(Long employeeId, Long id, EmployeeAddressRequest dto) {
        var employee = employeeService.getById(employeeId);
        var address = employee.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee address with id: " + id + " not found"));
        address = addressMapperService.toEntity(address,dto);
        employeeAddressRepository.save(address);
        employeeService.save(employee);
        return address;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var address = employee.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee address with id: " + id + " not found"));
        employee.removeAddress(address);
        employeeAddressRepository.delete(address);
    }

    @Override
    public EmployeeAddressResponse toDTO(EmployeeAddress address) {
        return addressMapperService.toDTO(address);
    }


}

