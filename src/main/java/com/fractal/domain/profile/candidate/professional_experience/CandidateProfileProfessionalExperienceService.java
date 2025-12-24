package com.fractal.domain.profile.candidate.professional_experience;

import com.fractal.domain.employee_management.professional_experience.EmployeeProfessionalExperience;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceResponse;

import java.util.List;

public interface CandidateProfileProfessionalExperienceService {
    List<EmployeeProfessionalExperience> getAll();


    EmployeeProfessionalExperience getById(Long id);

    EmployeeProfessionalExperienceResponse toDTO(EmployeeProfessionalExperience professionalExperience);


}
