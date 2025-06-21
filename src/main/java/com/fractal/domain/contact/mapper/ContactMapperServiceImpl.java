package com.fractal.domain.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.type.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ContactMapperServiceImpl implements ContactMapperService {

    private final ContactTypeService contactTypeService;

    @Override
    public ContactResponse toDTO(Contact contact) {
        return new ContactResponse(
                contact.getId(),
                contact.getContactType().getName(),
                contact.getValue(),
                contact.getCreatedDate()
        );
    }

    @Override
    public Contact toEntity(ContactRequest dto) {
        return mapToEntity(new Contact(),dto);
    }

    @Override
    public Contact toEntity(Contact contact, ContactRequest dto) {
        return mapToEntity(contact,dto);
    }

    private Contact mapToEntity(Contact contact, ContactRequest dto) {
        contact.setContactType(contactTypeService.getById(dto.contactTypeId()));
        contact.setValue(dto.value());
        return contact;
    }
}
