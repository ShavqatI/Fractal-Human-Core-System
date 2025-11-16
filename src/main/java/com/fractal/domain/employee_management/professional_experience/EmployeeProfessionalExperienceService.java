package com.fractal.domain.employee_management.professional_experience;

import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceRequest;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceResponse;

import java.util.List;

public interface EmployeeProfessionalExperienceService {

    EmployeeProfessionalExperience create(Long candidateId, EmployeeProfessionalExperienceRequest dto);

    List<EmployeeProfessionalExperience> getAllByCandidateId(Long candidateId);

    EmployeeProfessionalExperience getById(Long candidateId, Long id);

    EmployeeProfessionalExperienceResponse toDTO(EmployeeProfessionalExperience professionalExperience);

    EmployeeProfessionalExperience update(Long candidateId, Long id, EmployeeProfessionalExperienceRequest dto);

    void delete(Long candidateId, Long id);
}
