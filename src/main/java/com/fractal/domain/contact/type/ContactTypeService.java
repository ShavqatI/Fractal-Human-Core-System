package com.fractal.domain.contact.type;

import com.fractal.domain.contact.type.dto.ContactTypeRequest;
import com.fractal.domain.contact.type.dto.ContactTypeResponse;

import java.util.List;

public interface ContactTypeService {

    ContactType create(ContactTypeRequest dto);
    List<ContactType> getAll();
    ContactType getByCode(String code);
    ContactType getById(Long id);
    ContactType update(Long id, ContactTypeRequest dto);
    void deleteById(Long id);
    ContactTypeResponse toDTO(ContactType contactType);
}
