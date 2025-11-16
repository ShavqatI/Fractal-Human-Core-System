package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.mapper.EmploymentMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentMapperServiceImpl implements EmployeeEmploymentMapperService {

    private final EmploymentMapperService employmentMapperService;

    @Override
    public EmploymentResponse toDTO(EmployeeEmployment employment) {
        return employmentMapperService.toDTO(employment.getEmployment());
    }

    @Override
    public EmployeeEmployment toEntity(EmploymentRequest dto) {
        return mapToEntity(new EmployeeEmployment(), dto);
    }

    @Override
    public EmployeeEmployment toEntity(EmployeeEmployment employment, EmploymentRequest dto) {
        return mapToEntity(employment, dto);
    }

    @Override
    public EmployeeEmployment copy(Employment employment) {
        var employeeEmployment = EmployeeEmployment.builder().build();
        employeeEmployment.setEmployment(employmentMapperService.copy(employment));
        return employeeEmployment;
    }

    private EmployeeEmployment mapToEntity(EmployeeEmployment employment, EmploymentRequest dto) {
        employment.setEmployment(employmentMapperService.toEntity(dto));
        return employment;
    }


}
