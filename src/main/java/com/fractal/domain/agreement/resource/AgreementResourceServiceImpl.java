package com.fractal.domain.agreement.resource;

import com.fractal.domain.agreement.AgreementService;
import com.fractal.domain.agreement.resource.mapper.AgreementResourceMapperService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementResourceServiceImpl implements AgreementResourceService {

    private final AgreementResourceRepository resourceRepository;
    private final AgreementResourceMapperService resourceMapperService;
    private final AgreementService agreementService;
    private final FileService fileService;

    @Value("${resource-storage.agreement}")
    private String resourceStoragePath;

    @Override
    public AgreementResource create(Long agreementId, MultipartFile file) {
        var agreement = agreementService.getById(agreementId);
        var resource =  resourceMapperService.toEntity(file,resourceStoragePath);
        agreement.addResource(resource);
        agreementService.save(agreement);
        return resource;
    }

    @Override
    public List<AgreementResource> getAllByAgreementId(Long agreementId) {
        return resourceRepository.findAllByAgreementId(agreementId);
    }

    @Override
    public AgreementResource getById(Long agreementId, Long id) {
        return resourceRepository.findByAgreementIdAndId(agreementId,id).orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + id + " not found"));
    }

    @Override
    public AgreementResource update(Long agreementId, Long id, MultipartFile file) {
        var agreement = agreementService.getById(agreementId);
        var resource = agreement.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,file,resourceStoragePath);
        resourceRepository.save(resource);
        agreementService.save(agreement);
        return resource;
    }

    @Override
    public void delete(Long agreementId, Long id) {
        var agreement = agreementService.getById(agreementId);
        var resource = agreement.getResources()
                .stream()
                .filter(r -> r.getId().equals(agreementId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + id + " not found"));
        fileService.delete(resource.getUrl());
        agreement.removeResource(resource);
        agreementService.save(agreement);
    }

    @Override
    public ResourceResponse toDTO(AgreementResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
