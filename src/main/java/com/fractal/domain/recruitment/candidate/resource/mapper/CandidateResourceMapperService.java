package com.fractal.domain.recruitment.candidate.resource.mapper;

import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CandidateResourceMapperService {
    CandidateResourceResponse toDTO(CandidateResource resource);
    CandidateResource toEntity(CandidateResourceRequest dto,String url);
    CandidateResource toEntity(CandidateResource resource, CandidateResourceRequest dto,String url);
    //CandidateResource toEntity(CandidateResource resource, CandidateResourceRequest dto);
    //CandidateResourceRequest fileToRequest(Long candidateResourceTypeId,MultipartFile file,String url);
}


