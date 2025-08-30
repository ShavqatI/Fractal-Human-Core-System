package com.fractal.domain.recruitment.candidate.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.recruitment.candidate.contact.CandidateContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateContactMapperServiceImpl implements CandidateContactMapperService {
    private final ContactMapperService mapperService;
    @Override
    public ContactResponse toDTO(CandidateContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public CandidateContact toEntity(ContactRequest dto) {
        return mapToEntity(new CandidateContact(),mapperService.toEntity(dto));
    }

    @Override
    public CandidateContact toEntity(CandidateContact contact, ContactRequest dto) {
        return mapToEntity(contact,mapperService.toEntity(contact,dto));
    }

    private CandidateContact mapToEntity(CandidateContact candidateContact, Contact contact) {
        candidateContact.setContactType(contact.getContactType());
        candidateContact.setValue(contact.getValue());
        return candidateContact;
    }
}
