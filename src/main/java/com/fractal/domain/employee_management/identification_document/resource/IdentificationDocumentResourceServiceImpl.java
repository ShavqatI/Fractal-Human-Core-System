package com.fractal.domain.employee_management.identification_document.resource;

import com.fractal.domain.resource.ResourceService;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class IdentificationDocumentResourceServiceImpl implements IdentificationDocumentResourceService {
    private final IdentificationDocumentResourceRepository resourceRepository;
    private final ResourceService resourceService;
    @Override
    public ResourceResponse toDTO(IdentificationDocumentResource resource) {
        return resourceService.toDTO(resource);
    }

    @Override
    public IdentificationDocumentResource toEntity(ResourceRequest dto) {
        return (IdentificationDocumentResource) resourceService.toEntity(dto);
    }

    @Override
    public IdentificationDocumentResource toEntity(MultipartFile file,String url) {
        return (IdentificationDocumentResource) resourceService.toEntity(file,url);
    }

    @Override
    public IdentificationDocumentResource update(IdentificationDocumentResource resource, ResourceRequest dto) {
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
        return new ResourceRequest(url,file.getOriginalFilename(),file.getContentType(),file.getSize());
    }

    @Override
    public void delete(IdentificationDocumentResource resource) {
       resourceRepository.delete(resource);
    }
}
