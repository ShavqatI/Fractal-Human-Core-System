package com.fractal.domain.employee_management.employee.resource;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.resource.mapper.EmployeeResourceMapperService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeResourceServiceImpl implements EmployeeResourceService {

    private final EmployeeResourceRepository resourceRepository;
    private final EmployeeResourceMapperService resourceMapperService;
    private final EmployeeService employeeService;

    @Override
    public EmployeeResource create(Long employeeId, MultipartFile file) {
        var employee = employeeService.getById(employeeId);
        var resource = resourceMapperService.toEntity(file,null);
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
        return resourceRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Employee Resource  with id: " + id + " not found"));
    }

    @Override
    public EmployeeResource update(Long employeeId, Long id, MultipartFile file) {
        var employee = employeeService.getById(employeeId);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,resourceMapperService.fileToRequest(file,null));
        resourceRepository.save(resource);
        employeeService.save(employee);
        return resource;
    }

    @Override
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var resource = employee.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee Resource  with id: " + id + " not found"));
        resourceRepository.delete(resource);
        employeeService.save(employee);
    }

    @Override
    public ResourceResponse toDTO(EmployeeResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
