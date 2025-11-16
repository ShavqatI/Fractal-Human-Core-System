package com.fractal.domain.employee_management.employee.resource.type;

import com.fractal.domain.employee_management.employee.resource.type.dto.EmployeeResourceTypeRequest;
import com.fractal.domain.employee_management.employee.resource.type.dto.EmployeeResourceTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeResourceTypeServiceImpl implements EmployeeResourceTypeService {

    private final EmployeeResourceTypeRepository employeeResourceTypeRepository;

    @Override
    public EmployeeResourceType create(EmployeeResourceTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public EmployeeResourceType update(Long id, EmployeeResourceTypeRequest dto) {
        try {
            EmployeeResourceType employeeResourceType = findById(id);
            employeeResourceType.setCode(dto.code());
            employeeResourceType.setName(dto.name());
            return save(employeeResourceType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<EmployeeResourceType> getAll() {
        return employeeResourceTypeRepository.findAll();
    }

    @Override
    public EmployeeResourceType getByCode(String code) {
        return employeeResourceTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public EmployeeResourceType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
        employeeResourceTypeRepository.delete(findById(id));
    }

    @Override
    public EmployeeResourceTypeResponse toDTO(EmployeeResourceType employeeResourceType) {
        return new EmployeeResourceTypeResponse(
                employeeResourceType.getId(),
                employeeResourceType.getCode(),
                employeeResourceType.getName(),
                employeeResourceType.getCreatedDate()
        );
    }

    private EmployeeResourceType toEntity(EmployeeResourceTypeRequest dto) {
        return EmployeeResourceType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private EmployeeResourceType save(EmployeeResourceType employeeResourceType) {
        try {
            return employeeResourceTypeRepository.save(employeeResourceType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmployeeResourceType findById(Long id) {
        return employeeResourceTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
