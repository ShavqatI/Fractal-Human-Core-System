package com.fractal.domain.profile.candidate.education;

import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.employee_management.education.EmployeeEducation;

import java.util.List;

public interface CandidateProfileEducationService {
    List<EmployeeEducation> getAll();

    EmployeeEducation getById(Long id);
    EducationResponse toDTO(EmployeeEducation education);


}
