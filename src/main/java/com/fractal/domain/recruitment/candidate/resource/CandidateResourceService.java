package com.fractal.domain.recruitment.candidate.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CandidateResourceService {

    CandidateResource create(Long candidateId, MultipartFile file);
    List<CandidateResource> getAllByEducationId(Long candidateId);
    CandidateResource getById(Long candidateId , Long id);
    CandidateResource update(Long candidateId, Long id, MultipartFile file);
    void delete(Long candidateId,Long id);
    ResourceResponse toDTO(CandidateResource resource);
}
