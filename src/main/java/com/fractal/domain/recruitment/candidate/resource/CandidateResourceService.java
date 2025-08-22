package com.fractal.domain.recruitment.candidate.resource;

import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CandidateResourceService {

    CandidateResource create(Long candidateId, CandidateResourceRequest dto);
    List<CandidateResource> getAllByEducationId(Long candidateId);
    CandidateResource getById(Long candidateId , Long id);
    CandidateResource update(Long candidateId,Long id,CandidateResourceRequest dto);
    void delete(Long candidateId,Long id);
    CandidateResourceResponse toDTO(CandidateResource resource);
}
