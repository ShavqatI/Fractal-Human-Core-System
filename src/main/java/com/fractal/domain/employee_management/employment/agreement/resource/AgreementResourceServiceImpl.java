package com.fractal.domain.employee_management.employment.agreement.resource;

import com.fractal.domain.resource.ResourceService;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AgreementResourceServiceImpl implements AgreementResourceService {
    private final AgreementResourceRepository resourceRepository;
    private final ResourceService resourceService;
    @Override
    public ResourceResponse toDTO(AgreementResource resource) {
        return resourceService.toDTO(resource);
    }

    @Override
    public AgreementResource toEntity(ResourceRequest dto) {
        return (AgreementResource) resourceService.toEntity(dto);
    }

    @Override
    public AgreementResource toEntity(MultipartFile file, String url) {
        return (AgreementResource) resourceService.toEntity(file,url);
    }

    @Override
    public AgreementResource update(AgreementResource resource, ResourceRequest dto) {
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
    public void delete(AgreementResource resource) {
        resourceRepository.delete(resource);
    }
}
