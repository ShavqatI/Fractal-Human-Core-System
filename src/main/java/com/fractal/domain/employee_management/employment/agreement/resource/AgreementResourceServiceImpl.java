package com.fractal.domain.employee_management.employment.agreement.resource;

import com.fractal.domain.employee_management.employment.agreement.AgreementService;
import com.fractal.domain.employee_management.employment.agreement.resource.mapper.AgreementResourceMapperService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementResourceServiceImpl implements AgreementResourceService {

    private final AgreementResourceRepository resourceRepository;
    private final AgreementResourceMapperService resourceMapperService;
    private final AgreementService agreementService;

    @Override
    @Transactional
    public AgreementResource create(Long agreementId, MultipartFile file) {
        var agreement = agreementService.getById(agreementId);
        var resource = resourceMapperService.toEntity(file,null);
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
        return resourceRepository.findByAgreementIdAndId(agreementId,id).orElseThrow(()-> new ResourceNotFoundException("Agreement Resource  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public AgreementResource update(Long agreementId, Long id, MultipartFile file) {
        var agreement = agreementService.getById(agreementId);
        var resource = agreement.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,resourceMapperService.fileToRequest(file,null));
        resourceRepository.save(resource);
        agreementService.save(agreement);
        return resource;
    }

    @Override
    @Transactional
    public void delete(Long agreementId, Long id) {
        var agreement = agreementService.getById(agreementId);
        var resource = agreement.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement Resource  with id: " + id + " not found"));
        agreement.removeResource(resource);
        resourceRepository.delete(resource);
        agreementService.save(agreement);
    }

    @Override
    public ResourceResponse toDTO(AgreementResource resource) {
        return resourceMapperService.toDTO(resource);
    }


}
