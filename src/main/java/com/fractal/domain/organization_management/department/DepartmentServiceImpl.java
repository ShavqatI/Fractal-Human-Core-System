package com.fractal.domain.organization_management.department;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;
import com.fractal.domain.organization_management.department.mapper.DepartmentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapperService mapperService;
    @Override
    public Department create(DepartmentRequest dto) {
        Department department = mapperService.toEntity(dto);
        department.setLevelMap(getLevelMap(department));
        return save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
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
        child.setLevelMap(getLevelMap(department));
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

    private String getLevelMap(Department department) {
        var lastChild = department.getChildren().stream().sorted(Comparator.comparing(AbstractEntity::getId).reversed()).findFirst();
        String levelMap = null;
        if(lastChild.isPresent()) {
            String[] parts = levelMap.split("-");
            int lastIndex = parts.length - 1;
            int lastNumber = Integer.parseInt(parts[lastIndex]);
            lastNumber++;
            int digits = parts[lastIndex].length();
            parts[lastIndex] = String.format("%0" + digits + "d", lastNumber);
            levelMap = String.join("-", parts);
        }
        else if (department.getLevelMap() != null) {levelMap = department.getLevelMap() + "-001"; }
        else {levelMap =  "001"; }
        return  levelMap;
    }

}
