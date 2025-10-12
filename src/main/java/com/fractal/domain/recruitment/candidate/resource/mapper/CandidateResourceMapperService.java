package com.fractal.domain.recruitment.candidate.resource.mapper;

import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;

public interface CandidateResourceMapperService {
    CandidateResourceResponse toDTO(CandidateResource resource);
    CandidateResource toEntity(CandidateResourceRequest dto,String url);
    CandidateResource toEntity(CandidateResource resource, CandidateResourceRequest dto,String url);
}


