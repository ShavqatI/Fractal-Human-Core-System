package com.fractal.domain.profile.citizenship;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenshipService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileCitizenshipServiceImpl implements ProfileCitizenshipService {

   private final EmployeeCitizenshipService citizenshipService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeCitizenship> getAll() {
        return citizenshipService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeCitizenship getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public CitizenshipResponse toDTO(EmployeeCitizenship citizenship) {
        return citizenshipService.toDTO(citizenship);
    }


}
