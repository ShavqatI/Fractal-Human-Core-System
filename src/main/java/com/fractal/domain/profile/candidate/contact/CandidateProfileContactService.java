package com.fractal.domain.profile.candidate.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.recruitment.candidate.contact.CandidateContact;

import java.util.List;

public interface CandidateProfileContactService {
    CandidateContact create(ContactRequest dto);

    List<CandidateContact> getAll();

    CandidateContact getById(Long id);

    CandidateContact update(Long id, ContactRequest dto);

    void delete(Long id);

    ContactResponse toDTO(CandidateContact contact);


}
