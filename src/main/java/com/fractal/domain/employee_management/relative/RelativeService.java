package com.fractal.domain.employee_management.relative;

import com.fractal.domain.employee_management.education.Education;
import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.education.dto.EducationResponse;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import org.springframework.web.multipart.MultipartFile;


public interface RelativeService {
    Relative create(RelativeRequest dto);
    RelativeResponse toDTO(Relative relative);
    Relative toEntity(RelativeRequest dto);
    Relative update(Long id, RelativeRequest dto);
    void delete(Relative relative);

}
