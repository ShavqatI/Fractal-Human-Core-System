package com.fractal.domain.organization_management.department.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;
import com.fractal.domain.organization_management.unit.OrganizationUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class DepartmentMapperServiceImpl implements DepartmentMapperService {

    private final OrganizationUnitService organizationUnitService;
    private final StatusService statusService;

    @Override
    public DepartmentResponse toDTO(Department department) {
        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getLevelMap(),
                Optional.ofNullable(department.getParent())
                        .map(Department::getName)
                        .orElse(null),
                Optional.ofNullable(department.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                organizationUnitService.toDTO(department.getOrganizationUnit()),
                department.getOpenDate(),
                department.getOpenReason(),
                department.getCloseDate(),
                department.getCloseReason(),
                statusService.toCompactDTO(department.getStatus()),
                department.getCreatedDate()
        );
    }

    public DepartmentCompactResponse toCompactDTO(Department department) {
        return new DepartmentCompactResponse(
                department.getId(),
                department.getName()
        );
    }

    @Override
    public Department toEntity(DepartmentRequest dto) {
        return mapToEntity(new Department(),dto);
    }

    @Override
    public Department toEntity(Department department, DepartmentRequest dto) {
       return mapToEntity(department,dto);
    }

    private Department mapToEntity(Department department, DepartmentRequest dto) {
        department.setName(dto.name());
        department.setOrganizationUnit(organizationUnitService.getById(dto.organizationUnitId()));
        /*department.setOpenDate(dto.openDate());
        department.setOpenReason(dto.openReason());
        department.setCloseDate(dto.closeDate());
        department.setCloseReason(dto.closeReason());*/
        department.setStatus(statusService.getById(dto.statusId()));
        dto.children().forEach(child->department.addChild(toEntity(child)));
        return department;
    }




}
