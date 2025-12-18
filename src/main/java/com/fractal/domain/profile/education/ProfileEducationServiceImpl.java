package com.fractal.domain.profile.education;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.employee_management.education.EmployeeEducation;
import com.fractal.domain.employee_management.education.EmployeeEducationService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileEducationServiceImpl implements ProfileEducationService {

   private final EmployeeEducationService educationService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeEducation> getAll() {
        return educationService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeEducation getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public EducationResponse toDTO(EmployeeEducation education) {
        return educationService.toDTO(education);
    }


}
