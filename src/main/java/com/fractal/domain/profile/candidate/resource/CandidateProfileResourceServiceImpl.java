package com.fractal.domain.profile.candidate.resource;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperience;
import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.recruitment.candidate.resource.CandidateResourceService;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileResourceServiceImpl implements CandidateProfileResourceService {

   private final CandidateResourceService resourceService;
   private final AuthenticatedService authenticatedService;

    @Override
    public CandidateResource create(CandidateResourceRequest dto) {
        return resourceService.create(authenticatedService.getCandidateId(),dto);
    }

    @Override
    public List<CandidateResource> getAll() {
        return resourceService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateResource getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateResource update(Long id, CandidateResourceRequest dto) {
        return resourceService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
      resourceService.delete(authenticatedService.getCandidateId(), findById(id).getId());
    }

    @Override
    public CandidateResourceResponse toDTO(CandidateResource resource) {
        return resourceService.toDTO(resource);
    }

    private CandidateResource findById(Long id) {
        return resourceService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(resource -> resource.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
