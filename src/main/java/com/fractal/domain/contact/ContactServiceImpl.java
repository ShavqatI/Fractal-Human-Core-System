package com.fractal.domain.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactMapperService mapperService;

    @Override
    public ContactResponse toDTO(Contact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public Contact toEntity(ContactRequest dto) {
        return mapperService.toEntity(dto);
    }
}
