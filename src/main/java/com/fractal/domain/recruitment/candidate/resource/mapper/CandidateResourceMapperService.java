package com.fractal.domain.recruitment.candidate.resource.mapper;

import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CandidateResourceMapperService {
    ResourceResponse toDTO(CandidateResource resource);
    CandidateResource toEntity(ResourceRequest dto);
    CandidateResource toEntity(MultipartFile file, String url);
    CandidateResource toEntity(CandidateResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


