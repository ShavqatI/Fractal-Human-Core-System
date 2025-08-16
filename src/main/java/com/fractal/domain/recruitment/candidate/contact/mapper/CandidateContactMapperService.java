package com.fractal.domain.recruitment.candidate.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.recruitment.candidate.contact.CandidateContact;

public interface CandidateContactMapperService {
    ContactResponse toDTO(CandidateContact contact);
    CandidateContact toEntity(ContactRequest dto);
    CandidateContact toEntity(CandidateContact contact, ContactRequest dto);
}


