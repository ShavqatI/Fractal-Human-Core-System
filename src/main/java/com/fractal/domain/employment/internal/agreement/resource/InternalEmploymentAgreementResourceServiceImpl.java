package com.fractal.domain.employment.internal.agreement.resource;

import com.fractal.domain.employment.internal.agreement.InternalEmploymentAgreementService;
import com.fractal.domain.employment.internal.agreement.resource.mapper.InternalEmploymentAgreementResourceMapperService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalEmploymentAgreementResourceServiceImpl implements InternalEmploymentAgreementResourceService {

    private final InternalEmploymentAgreementResourceRepository resourceRepository;
    private final InternalEmploymentAgreementResourceMapperService resourceMapperService;
    private final InternalEmploymentAgreementService internalEmploymentAgreementService;

    @Override
    @Transactional
    public InternalEmploymentAgreementResource create(Long agreementId, MultipartFile file) {
        var agreement = internalEmploymentAgreementService.getById(agreementId);
        var resource = resourceMapperService.toEntity(file,null);
        agreement.addResource(resource);
        internalEmploymentAgreementService.save(agreement);
        return resource;
    }

    @Override
    public List<InternalEmploymentAgreementResource> getAllByAgreementId(Long agreementId) {
        return resourceRepository.findAllByInternalEmploymentAgreementId(agreementId);
    }

    @Override
    public InternalEmploymentAgreementResource getById(Long agreementId, Long id) {
        return resourceRepository.findByInternalEmploymentAgreementIdAndId(agreementId,id).orElseThrow(()-> new ResourceNotFoundException("Agreement Resource  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InternalEmploymentAgreementResource update(Long agreementId, Long id, MultipartFile file) {
        var agreement = internalEmploymentAgreementService.getById(agreementId);
        var resource = agreement.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,resourceMapperService.fileToRequest(file,null));
        resourceRepository.save(resource);
        internalEmploymentAgreementService.save(agreement);
        return resource;
    }

    @Override
    @Transactional
    public void delete(Long agreementId, Long id) {
        var agreement = internalEmploymentAgreementService.getById(agreementId);
        var resource = agreement.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement Resource  with id: " + id + " not found"));
        agreement.removeResource(resource);
        resourceRepository.delete(resource);
        internalEmploymentAgreementService.save(agreement);
    }

    @Override
    public ResourceResponse toDTO(InternalEmploymentAgreementResource resource) {
        return resourceMapperService.toDTO(resource);
    }


}
