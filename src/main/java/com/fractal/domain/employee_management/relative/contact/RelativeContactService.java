package com.fractal.domain.employee_management.relative.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

public interface RelativeContactService {

    ContactResponse toDTO(RelativeContact contact);
    RelativeContact toEntity(ContactRequest dto);
    RelativeContact update(Long id, ContactRequest dto);
    void delete(RelativeContact contact);
    RelativeContact findById(Long id);
}
