package com.fractal.domain.employee_management.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

public interface EmployeeContactService {

    ContactResponse toDTO(EmployeeContact contact);
    EmployeeContact toEntity(ContactRequest dto);
    EmployeeContact update(Long id, ContactRequest dto);
    void delete(EmployeeContact contact);
    EmployeeContact findById(Long id);
}
