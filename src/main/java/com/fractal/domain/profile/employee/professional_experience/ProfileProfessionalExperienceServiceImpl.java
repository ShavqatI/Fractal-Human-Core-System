package com.fractal.domain.profile.employee.professional_experience;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.professional_experience.EmployeeProfessionalExperience;
import com.fractal.domain.employee_management.professional_experience.EmployeeProfessionalExperienceService;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileProfessionalExperienceServiceImpl implements ProfileProfessionalExperienceService {

   private final EmployeeProfessionalExperienceService professionalExperienceService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeProfessionalExperience> getAll() {
        return professionalExperienceService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeProfessionalExperience getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public EmployeeProfessionalExperienceResponse toDTO(EmployeeProfessionalExperience professionalExperience) {
        return professionalExperienceService.toDTO(professionalExperience);
    }


}
