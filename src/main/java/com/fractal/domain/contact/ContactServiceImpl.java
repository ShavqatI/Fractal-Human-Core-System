package com.fractal.domain.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.type.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
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
        return Contact.builder()
                .contactType(contactTypeService.getById(dto.contactTypeId()))
                .value(dto.value())
                .build();
    }
}
