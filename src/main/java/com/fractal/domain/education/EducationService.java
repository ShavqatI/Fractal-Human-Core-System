package com.fractal.domain.education;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;

import java.util.List;


public interface EducationService {
    /*Education create(Long employeeId, EducationRequest dto);
    List<Education> getAllByEmployeeId(Long employeeId);
    Education getById(Long employeeId , Long id);
    Education getById(Long id);
    Education update(Long id, Long educationId, EducationRequest dto);
    void delete(Long employeeId, Long id);*/
    Education getById(Long id);
    EducationResponse toDTO(Education education);
    Education save(Education education);
}
