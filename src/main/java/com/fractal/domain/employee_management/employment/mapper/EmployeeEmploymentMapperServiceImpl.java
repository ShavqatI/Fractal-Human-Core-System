package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.employee_management.employee.mapper.EmployeeMapperService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import com.fractal.domain.employment.mapper.EmploymentMapperService;
import com.fractal.domain.employment.type.EmploymentTypeService;
import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.mapper.DepartmentMapperService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.mapper.OrganizationMapperService;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentMapperServiceImpl implements EmployeeEmploymentMapperService {

    private final EmploymentMapperService employmentMapperService;
    private final EmployeeMapperService employeeMapperService;
    private final EmploymentTypeService employmentTypeService;
    private final OrganizationMapperService organizationMapperService;
    private final DepartmentMapperService departmentMapperService;
    private final PositionService positionService;

    @Override
    public EmploymentResponse toDTO(EmployeeEmployment employment) {
        return employmentMapperService.toDTO(employment.getEmployment());
    }

    @Override
    public InternalEmploymentApprovedResponse toApprovedDTO(EmployeeEmployment employment) {
        var internalEmployment = (InternalEmployment) Hibernate.unproxy(employment.getEmployment());

        return new InternalEmploymentApprovedResponse(
                employment.getId(),
                employeeMapperService.toCompactDTO(employment.getEmployee()),
                internalEmployment.getStartDate(),
                internalEmployment.getEndDate(),
                employmentTypeService.toCompactDTO(internalEmployment.getEmploymentType()),
                organizationMapperService.toCompactDTO(internalEmployment.getOrganization()),
                departmentMapperService.toCompactDTO(internalEmployment.getDepartment()),
                positionService.toCompactDTO(internalEmployment.getPosition()),
                employment.getCreatedDate()
        );
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
