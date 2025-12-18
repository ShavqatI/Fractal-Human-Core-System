package com.fractal.domain.profile.employment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileEmploymentServiceImpl implements ProfileEmploymentService {

   private final EmployeeEmploymentService employmentService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeEmployment> getAll() {
        return employmentService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeEmployment getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public EmploymentResponse toDTO(EmployeeEmployment employment) {
        return employmentService.toDTO(employment);
    }


}
