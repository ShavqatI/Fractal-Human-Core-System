package com.fractal.domain.employee_management.employee.resource;

import com.fractal.domain.resource.ResourceService;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class EmployeeResourceServiceImpl implements EmployeeResourceService {

    private final EmployeeResourceRepository resourceRepository;
    private final ResourceService resourceService;
    @Override
    public ResourceResponse toDTO(EmployeeResource resource) {
        return resourceService.toDTO(resource);
    }

    @Override
    public EmployeeResource toEntity(ResourceRequest dto) {
        return (EmployeeResource) resourceService.toEntity(dto);
    }

    @Override
    public EmployeeResource toEntity(MultipartFile file, String url) {
        return (EmployeeResource) resourceService.toEntity(file,url);
    }

    @Override
    public EmployeeResource update(EmployeeResource resource, ResourceRequest dto) {
        try {
            resource.setUrl(dto.url());
            resource.setFileName(dto.fileName());
            resource.setContentType(dto.contentType());
            resource.setSizeInBytes(dto.sizeInBytes());
            return resourceRepository.save(resource);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceService.fileToRequest(file,url);
    }

    @Override
    public void delete(EmployeeResource resource) {
        resourceRepository.delete(resource);
    }

    @Override
    public EmployeeResource findById(Long id) {
        return resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agreement Resource with id: " + id + " not found"));
    }
}
