package com.fractal.domain.organization_management.department.mapper;

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

    @Override
    public DepartmentResponse toDTO(Department department) {
        return new DepartmentResponse(
                department.getId(),
                department.getCode(),
                department.getName(),
                department.getLevel(),
                department.getLevelMap(),
                Optional.ofNullable(department.getParent())
                        .map(Department::getName)
                        .orElse(null),
                Optional.ofNullable(department.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                department.getOrganizationUnit().getName(),
                department.getCreatedDate()
        );
    }

    public DepartmentCompactResponse toCompactDTO(Department department) {
        return new DepartmentCompactResponse(
                department.getId(),
                department.getCode(),
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
        department.setCode(dto.code());
        department.setName(dto.name());
        department.setLevel(dto.level());
        department.setLevelMap(dto.levelMap());
        department.setOrganizationUnit(organizationUnitService.getByCode(dto.organizationUnit()));
        dto.children().forEach(child->department.addChild(toEntity(child)));
        return department;

    }


}
