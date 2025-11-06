package com.fractal.domain.identification_document.resource;

import com.fractal.domain.identification_document.IdentificationDocumentService;
import com.fractal.domain.identification_document.resource.mapper.IdentificationDocumentResourceMapperService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdentificationDocumentResourceServiceImpl implements IdentificationDocumentResourceService {

    private final IdentificationDocumentResourceRepository resourceRepository;
    private final IdentificationDocumentResourceMapperService resourceMapperService;
    private final IdentificationDocumentService identificationDocumentService;
    private final FileService fileService;

    @Value("${resource-storage.identification-document}")
    private String resourceStoragePath;

    @Override
    @Transactional
    public IdentificationDocumentResource create(Long identificationDocumentId, MultipartFile file) {
        var identificationDocument = identificationDocumentService.getById(identificationDocumentId);
        var resource = resourceMapperService.toEntity(file,resourceStoragePath);
        identificationDocument.addResource(resource);
        identificationDocumentService.save(identificationDocument);
        return resource;
    }

    @Override
    public List<IdentificationDocumentResource> getAllByIdentificationDocumentId(Long identificationDocumentId) {
        return resourceRepository.findAllByIdentificationDocumentId(identificationDocumentId);
    }

    @Override
    public IdentificationDocumentResource getById(Long identificationDocumentId, Long id) {
        return resourceRepository.findByIdentificationDocumentIdAndId(identificationDocumentId,id).orElseThrow(()-> new ResourceNotFoundException("Identification Document Resource  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public IdentificationDocumentResource update(Long identificationDocumentId, Long id, MultipartFile file) {
        try {
            var identificationDocument = identificationDocumentService.getById(identificationDocumentId);
            var resource = identificationDocument.getResources()
                    .stream()
                    .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification Document Resource  with id: " + id + " not found"));
            resource = resourceMapperService.toEntity(resource,file,resourceStoragePath);
            resource = resourceRepository.save(resource);
            identificationDocumentService.save(identificationDocument);
            return resource;
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    @Transactional
    public void delete(Long identificationDocumentId, Long id) {
        var identificationDocument = identificationDocumentService.getById(identificationDocumentId);
        var resource = identificationDocument.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification Document Resource  with id: " + id + " not found"));
        fileService.delete(resource.getUrl());
        identificationDocument.removeResource(resource);
        identificationDocumentService.save(identificationDocument);
    }

    @Override
    public ResourceResponse toDTO(IdentificationDocumentResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
