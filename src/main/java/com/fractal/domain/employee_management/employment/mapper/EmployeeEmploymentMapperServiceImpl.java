package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import com.fractal.domain.employment.mapper.EmploymentMapperService;
import com.fractal.domain.employment.type.EmploymentTypeService;
import com.fractal.domain.organization_management.department.mapper.DepartmentMapperService;
import com.fractal.domain.organization_management.organization.mapper.OrganizationMapperService;
import com.fractal.domain.organization_management.position.PositionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentMapperServiceImpl implements EmployeeEmploymentMapperService {

    private final EmploymentMapperService employmentMapperService;
    private final StatusService statusService;


    @Override
    public EmploymentResponse toDTO(EmployeeEmployment employment) {
        return employmentMapperService.toDTO(employment.getEmployment());
    }

    @Override
    public EmployeeEmployment toEntity(EmploymentRequest dto) {
        var employeeEmployment = mapToEntity(new EmployeeEmployment(), dto);
        employeeEmployment.setStatus(statusService.getByCode("CREATED"));
        return employeeEmployment;
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
