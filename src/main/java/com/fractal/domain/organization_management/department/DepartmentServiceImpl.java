package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;
import com.fractal.domain.organization_management.department.mapper.DepartmentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapperService mapperService;
    @Override
    public Department create(DepartmentRequest dto) {
        return save(mapperService.toEntity(dto));
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
    public Department update(Long id, DepartmentRequest dto) {
        try {
          return save(mapperService.toEntity(findById(id),dto));
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
        return mapperService.toDTO(department);
    }

    @Override
    public DepartmentCompactResponse toCompactDTO(Department department) {
        return mapperService.toCompactDTO(department);
    }


    @Override
    public Department addChild(Long id, DepartmentRequest dto) {
        var department = findById(id);
        var child = mapperService.toEntity(dto);
        if (department.getOrganizationUnit().equals(child.getOrganizationUnit())) {
            throw new RuntimeException("Child can not have same organization unit as parent ");
        }
        department.addChild(child);
        return save(department);
    }

    @Override
    public Department updateChild(Long id, Long childId, DepartmentRequest dto) {
        var department = findById(id);
        var child = department.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        update(child.getId(),dto);
        return save(department);
    }

    @Override
    public Department deleteChild(Long id, Long childId) {
        var department = findById(id);
        var child = department.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        department.removeChild(child);
        return save(department);
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
