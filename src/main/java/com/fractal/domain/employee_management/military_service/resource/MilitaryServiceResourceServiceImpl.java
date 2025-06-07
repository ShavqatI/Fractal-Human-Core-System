package com.fractal.domain.employee_management.military_service.resource;

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
public class MilitaryServiceResourceServiceImpl implements MilitaryServiceResourceService {

    private final MilitaryServiceResourceRepository resourceRepository;
    private final ResourceService resourceService;
    @Override
    public ResourceResponse toDTO(MilitaryServiceResource resource) {
        return resourceService.toDTO(resource);
    }

    @Override
    public MilitaryServiceResource toEntity(ResourceRequest dto) {
        return (MilitaryServiceResource) resourceService.toEntity(dto);
    }

    @Override
    public MilitaryServiceResource toEntity(MultipartFile file, String url) {
        return (MilitaryServiceResource) resourceService.toEntity(file,url);
    }

    @Override
    public MilitaryServiceResource update(MilitaryServiceResource resource, ResourceRequest dto) {
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
    public void delete(MilitaryServiceResource resource) {
        resourceRepository.delete(resource);
    }

    @Override
    public MilitaryServiceResource findById(Long id) {
        return resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Agreement Resource with id: " + id + " not found"));
    }
}
