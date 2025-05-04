package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCreate;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;
import com.fractal.domain.organization_management.organization_unit.OrganizationUnitService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final OrganizationUnitService organizationUnitService;
    @Override
    public Department create(DepartmentCreate dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll()
                .stream()
                .peek(department -> department.setChildren(new ArrayList<>()))
                .collect(Collectors.toList());
    }

    @Override
    public Department getByCode(String code) {
        return departmentRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Department with code : " + code + " not found"));
    }

    @Override
    public Department getById(Long id) {
        return findById(id);
    }

    @Override
    public Department update(Long id, DepartmentCreate dto) {
        try {
         Department department = findById(id);
         department.setCode(dto.code());
         department.setName(dto.name());
         department.setLevel(dto.level());
         department.setLevelMap(dto.levelMap());
         department.setParent(departmentRepository.findByCode(dto.parent()).orElse(null));
         department.setOrganizationUnit(organizationUnitService.getByCode(dto.organizationUnit()));
         return save(department);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.delete(findById(id));
    }

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
    private Department toEntity(DepartmentCreate dto) {
        return Department.builder()
                .code(dto.code())
                .name(dto.name())
                .level(dto.level())
                .levelMap(dto.levelMap())
                .parent(departmentRepository.findByCode(dto.parent()).orElse(null))
                .organizationUnit(organizationUnitService.getByCode(dto.organizationUnit()))
                .build();
    }

    private Department save(Department department) {
        try {
            return departmentRepository.save(department);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department with id: " + id + " not found"));
    }

}
