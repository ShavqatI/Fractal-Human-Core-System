package com.fractal.domain.profile.military_service;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.military_service.EmployeeMilitaryService;
import com.fractal.domain.employee_management.military_service.EmployeeMilitaryServiceService;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileMilitaryServiceServiceImpl implements ProfileMilitaryServiceService {

   private final EmployeeMilitaryServiceService languageSkillService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeMilitaryService> getAll() {
        return languageSkillService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeMilitaryService getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public MilitaryServiceResponse toDTO(EmployeeMilitaryService militaryService) {
        return languageSkillService.toDTO(militaryService);
    }


}
