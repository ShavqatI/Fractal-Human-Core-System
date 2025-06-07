package com.fractal.domain.employee_management.education;

import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.education.dto.EducationResponse;
import org.springframework.web.multipart.MultipartFile;


public interface EducationService {
    Education create(EducationRequest dto);
    EducationResponse toDTO(Education education);
    Education toEntity(EducationRequest dto);
    Education update(Long id,EducationRequest dto);
    void delete(Education education);
    Education addResource(Long id, MultipartFile file, String url);
    Education updateResource(Long id, Long resourceId, MultipartFile file);
    Education deleteResource(Long id, Long resourceId);
}
