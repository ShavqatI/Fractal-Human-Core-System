package com.fractal.domain.employee_management.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.contact.EmployeeContact;

public interface EmployeeContactMapperService {
    ContactResponse toDTO(EmployeeContact contact);

    EmployeeContact toEntity(ContactRequest dto);

    EmployeeContact toEntity(EmployeeContact contact, ContactRequest dto);
}


