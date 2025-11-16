package com.fractal.domain.employee_management.relative.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.relative.contact.RelativeContact;

public interface RelativeContactMapperService {
    ContactResponse toDTO(RelativeContact contact);

    RelativeContact toEntity(ContactRequest dto);

    RelativeContact toEntity(RelativeContact contact, ContactRequest dto);
}


