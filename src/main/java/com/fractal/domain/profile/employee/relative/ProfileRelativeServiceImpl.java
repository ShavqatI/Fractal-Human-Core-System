package com.fractal.domain.profile.employee.relative;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.relative.RelativeService;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileRelativeServiceImpl implements ProfileRelativeService {

   private final RelativeService relativeService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<Relative> getAll() {
        return relativeService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public Relative getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public RelativeResponse toDTO(Relative relative) {
        return relativeService.toDTO(relative);
    }


}
