package com.fractal.domain.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

public interface ContactService {

    ContactResponse toDTO(Contact contact);

    Contact toEntity(ContactRequest dto);

}
