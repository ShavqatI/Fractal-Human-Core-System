package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCreateDto;
import com.fractal.domain.organization_management.department.dto.DepartmentResponseDto;
import com.fractal.domain.organization_management.organization_unit.OrganizationUnitService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final OrganizationUnitService organizationUnitService;
    @Override
    public Department create(DepartmentCreateDto dto) {
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
    public Department update(Long id, DepartmentCreateDto dto) {
        Department department = findById(id);
        department.setCode(dto.code());
        department.setName(dto.name());
        department.setLevel(dto.level());
        department.setLevelMap(dto.levelMap());
        department.setParent(getParentByCode(dto.parent()));
        department.setOrganizationUnit(organizationUnitService.findByCode(dto.organizationUnit()));
        return save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.delete(findById(id));
    }

    public DepartmentResponseDto toDTO(Department department) {
        return new DepartmentResponseDto(
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
    private Department toEntity(DepartmentCreateDto dto) {
        return Department.builder()
                .code(dto.code())
                .name(dto.name())
                .level(dto.level())
                .levelMap(dto.levelMap())
                .parent(getParentByCode(dto.parent()))
                .organizationUnit(organizationUnitService.findByCode(dto.organizationUnit()))
                .build();
    }

    private Department save(Department department) {
        return departmentRepository.save(department);
    }

    private Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department with id: " + id + " not found"));
    }
    private Department findByCode(String code) {
        return departmentRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Department with code : " + code + " not found"));
    }

    private Department getParentByCode(String code) {
        try {
            return findByCode(code);
        }
        catch (Exception e){

        }
        return null;
    }
}
