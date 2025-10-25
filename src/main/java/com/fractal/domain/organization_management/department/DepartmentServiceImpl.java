package com.fractal.domain.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;
import com.fractal.domain.organization_management.department.mapper.DepartmentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapperService mapperService;
    @Override
    @Transactional
    public Department create(DepartmentRequest dto) {
        Department department = mapperService.toEntity(dto);
        department= assignLevelMap(department);
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
        //child.setLevelMap(getLevelMap(department));
        child.setCode(generateCode(child));
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

    public Department assignLevelMap(Department department) {
        // Root department (no parent)
        if (department.getId() == null) {
            String levelMap = "001";

            var lastDepartment = departmentRepository.findFirstByOrderByIdDesc();
            if (lastDepartment.isPresent()) {
                String lastLevel = lastDepartment.get().getLevelMap().substring(0, 3);
                int nextNumber = Integer.parseInt(lastLevel) + 1;
                levelMap = String.format("%03d", nextNumber);
            }

            department.setLevelMap(levelMap);
        }
        // Recursively assign for children
       for (int i = 0; i < department.getChildren().size(); i++) {
            String childLevel = department.getLevelMap() + String.format("%03d", i + 1);
            department.getChildren().get(i).setLevelMap(childLevel);
            assignLevelMap(department.getChildren().get(i)); // 🔁 recursion
        }
       return department;
    }

    /*private String getLevelMap(Department department) {
        String levelMap;
        if(department.getId() == null) {
            levelMap = "001";
            var lastDepartment = departmentRepository.findFirstByOrderByIdDesc();
            if (lastDepartment.isPresent())
                levelMap =  String.format("%0" + 3 + "d", Integer.parseInt( lastDepartment.get().getLevelMap().substring(0,3)) + 1 );
            department.setLevelMap(levelMap);
            List<Department> children = department.getChildren();
            IntStream.range(0, children.size())
                    .forEach(i -> {
                        Department child = children.get(i);
                        child.setLevelMap(department.getLevelMap() + String.format("%0" + 3 + "d", i));
                      });
                   }


        var lastChild = department.getChildren().stream().sorted(Comparator.comparing(AbstractEntity::getId).reversed()).filter(department1 -> department1.getLevelMap() != null).findFirst();
        String levelMap;
        if(lastChild.isPresent()) {
            levelMap = lastChild.get().getLevelMap();
            String[] parts = levelMap.split("-");
            int lastIndex = parts.length - 1;
            int lastNumber = Integer.parseInt(parts[lastIndex]);
            lastNumber++;
            int digits = parts[lastIndex].length();
            parts[lastIndex] = String.format("%0" + digits + "d", lastNumber);
            levelMap = String.join("-", parts);
        }
        else if (department.getLevelMap() != null) {
            levelMap = department.getLevelMap() + "-001";
        }
        else {
            levelMap = "001";
            var lastDepartment = departmentRepository.findFirstByOrderByIdDesc();
            if (lastDepartment.isPresent())
            levelMap =  String.format("%0" + 3 + "d", Integer.parseInt( lastDepartment.get().getLevelMap().substring(0,3)) + 1 );
        }
        return  levelMap;
    }

     */

    private String generateCode(Department department) {
        return department.getOrganizationUnit().getCode() + "_" + department.getLevelMap().replace("-","_");
    }

}
