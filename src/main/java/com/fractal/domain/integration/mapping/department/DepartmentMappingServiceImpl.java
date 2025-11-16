package com.fractal.domain.integration.mapping.department;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingRequest;
import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingResponse;
import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class DepartmentMappingServiceImpl implements DepartmentMappingService {

    private final DepartmentMappingRepository departmentMappingRepository;
    private final DepartmentService departmentService;
    private final StatusService statusService;

    @Override
    public DepartmentMapping create(DepartmentMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<DepartmentMapping> getAll() {
        return departmentMappingRepository.findAll();
    }

    @Override
    public DepartmentMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public DepartmentMapping update(Long id, DepartmentMappingRequest dto) {
        try {
            DepartmentMapping departmentMapping = findById(id);
            departmentMapping.setDepartment(departmentService.getById(dto.departmentId()));
            departmentMapping.setReferenceType(dto.referenceType());
            departmentMapping.setReference(dto.reference());
            departmentMapping.setStatus(statusService.getById(dto.statusId()));
            return save(departmentMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        departmentMappingRepository.delete(findById(id));
    }

    @Override
    public DepartmentMappingResponse toDTO(DepartmentMapping departmentMapping) {
        return new DepartmentMappingResponse(
                departmentMapping.getId(),
                departmentService.toCompactDTO(departmentMapping.getDepartment()),
                departmentMapping.getReferenceType(),
                departmentMapping.getReference(),
                statusService.toCompactDTO(departmentMapping.getStatus()),
                departmentMapping.getCreatedDate()
        );
    }

    private DepartmentMapping toEntity(DepartmentMappingRequest dto) {
        return DepartmentMapping.builder()
                .department(departmentService.getById(dto.departmentId()))
                .referenceType(dto.referenceType())
                .reference(dto.reference())
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private DepartmentMapping save(DepartmentMapping departmentMapping) {
        try {
            return departmentMappingRepository.save(departmentMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private DepartmentMapping findById(Long id) {
        return departmentMappingRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
