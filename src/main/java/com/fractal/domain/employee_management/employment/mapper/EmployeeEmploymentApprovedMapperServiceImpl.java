package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import com.fractal.domain.employment.type.EmploymentTypeService;
import com.fractal.domain.organization_management.department.mapper.DepartmentMapperService;
import com.fractal.domain.organization_management.organization.mapper.OrganizationMapperService;
import com.fractal.domain.organization_management.position.PositionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentApprovedMapperServiceImpl implements EmployeeEmploymentApprovedMapperService {

    private final EmployeeService employeeService;
    private final EmploymentTypeService employmentTypeService;
    private final OrganizationMapperService organizationMapperService;
    private final DepartmentMapperService departmentMapperService;
    private final PositionService positionService;

    @Override
    public InternalEmploymentApprovedResponse toDTO(EmployeeEmployment employment) {
        var internalEmployment = (InternalEmployment) Hibernate.unproxy(employment.getEmployment());
        return new InternalEmploymentApprovedResponse(
                employment.getId(),
                employeeService.toCompactDTO(employment.getEmployee()),
                internalEmployment.getStartDate(),
                internalEmployment.getEndDate(),
                employmentTypeService.toCompactDTO(internalEmployment.getEmploymentType()),
                organizationMapperService.toCompactDTO(internalEmployment.getOrganization()),
                departmentMapperService.toCompactDTO(internalEmployment.getDepartment()),
                positionService.toCompactDTO(internalEmployment.getPosition()),
                employment.getCreatedDate()
        );
    }
}
