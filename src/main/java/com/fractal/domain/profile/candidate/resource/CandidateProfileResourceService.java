package com.fractal.domain.profile.candidate.resource;

import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;

import java.util.List;

public interface CandidateProfileResourceService {
    CandidateResource create(CandidateResourceRequest dto);
    List<CandidateResource> getAll();
    CandidateResource getById(Long id);
    CandidateResource update(Long id, CandidateResourceRequest dto);
    void delete(Long id);
    CandidateResourceResponse toDTO(CandidateResource resource);

}
