package com.fractal.domain.recruitment.candidate.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface CandidateContactService {

    CandidateContact create(Long candidateId, ContactRequest dto);

    List<CandidateContact> getAllByCandidateId(Long candidateId);

    CandidateContact getById(Long candidateId, Long id);

    CandidateContact update(Long candidateId, Long id, ContactRequest dto);

    void delete(Long candidateId, Long id);

    ContactResponse toDTO(CandidateContact contact);

}
