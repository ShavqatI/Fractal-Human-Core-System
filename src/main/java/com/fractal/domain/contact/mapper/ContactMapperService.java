package com.fractal.domain.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

public interface ContactMapperService {
    ContactResponse toDTO(Contact contact);
    Contact toEntity(ContactRequest dto);
    Contact toEntity(Contact contact, ContactRequest dto);
}


