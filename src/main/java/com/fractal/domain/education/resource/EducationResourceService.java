package com.fractal.domain.education.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EducationResourceService {

    EducationResource create(Long educationId, MultipartFile file);
    List<EducationResource> getAllByEducationId(Long educationId);
    EducationResource getById(Long educationId , Long id);
    EducationResource update(Long educationId, Long id, MultipartFile file);
    void delete(Long educationId,Long id);
    ResourceResponse toDTO(EducationResource resource);
}
