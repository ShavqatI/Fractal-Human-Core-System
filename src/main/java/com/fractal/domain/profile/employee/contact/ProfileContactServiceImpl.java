package com.fractal.domain.profile.employee.contact;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.contact.EmployeeContact;
import com.fractal.domain.employee_management.contact.EmployeeContactService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileContactServiceImpl implements ProfileContactService {

   private final EmployeeContactService contactService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeContact> getAll() {
        return contactService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeContact getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public ContactResponse toDTO(EmployeeContact contact) {
        return contactService.toDTO(contact);
    }


}
