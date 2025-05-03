package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.organization_unit.OrganizationUnit;
import com.fractal.domain.organization_management.organization_unit.OrganizationUnitService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final OrganizationUnitService organizationUnitService;
    @Override
    public Department create(DepartmentDto dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getByCode(String code) {
        return departmentRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Department with code: " + code + " not found"));
    }

    @Override
    public Department getById(Long id) {
        return findById(id);
    }

    @Override
    public Department update(Long id, DepartmentDto dto) {
        Department department = findById(id);
        department.setCode(dto.code());
        department.setName(dto.name());
        department.setLevel(dto.level());
        department.setLevelMap(dto.levelMap());
        department.setOrganizationUnit(organizationUnitService.findByCode(dto.organizationUnit().code()));
        return null;
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.delete(findById(id));
    }

    private DepartmentDto toDTO(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getCode(),
                department.getName(),
                department.getLevel(),
                department.getLevelMap(),
                toDTO(department.getParent()),
                department.getChildren().stream().map(this::toDTO).collect(Collectors.toList()),
                organizationUnitService.toDTO(department.getOrganizationUnit()),
                department.getCreatedDate()
        );
    }
    private Department toEntity(DepartmentDto dto) {
        return Department.builder()
                .code(dto.code())
                .name(dto.name())
                .level(dto.level())
                .levelMap(dto.levelMap())
                .parent(toEntity(dto.parent()))
                .children(dto.children().stream().map(this::toEntity).collect(Collectors.toList()))
                .organizationUnit(organizationUnitService.findByCode(dto.organizationUnit().code()))
                .build();
    }

    private Department save(Department department) {
        return departmentRepository.save(department);
    }

    private Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department with id: " + id + " not found"));
    }
}
