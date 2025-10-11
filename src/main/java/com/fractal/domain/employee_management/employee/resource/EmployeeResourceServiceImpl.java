package com.fractal.domain.employee_management.employee.resource;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceRequest;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;
import com.fractal.domain.employee_management.employee.resource.mapper.EmployeeResourceMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeResourceServiceImpl implements EmployeeResourceService {

    private final EmployeeResourceRepository resourceRepository;
    private final EmployeeResourceMapperService resourceMapperService;
    private final EmployeeService employeeService;

    @Override
    public EmployeeResource create(Long employeeId, EmployeeResourceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var resource =  resourceMapperService.toEntity(dto,null);
        employee.addResource(resource);
        employeeService.save(employee);
        return resource;
    }

    @Override
    public List<EmployeeResource> getAllByEmployeeId(Long employeeId) {
        return resourceRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeResource getById(Long employeeId, Long id) {
        return resourceRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public EmployeeResource update(Long employeeId,Long id,EmployeeResourceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        resource = resourceMapperService.toEntity(resource,dto,null);
        resourceRepository.save(resource);
        employeeService.save(employee);
        return resource;
    }

    @Override
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        employee.removeResource(resource);
        employeeService.save(employee);
    }

    @Override
    public EmployeeResourceResponse toDTO(EmployeeResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
