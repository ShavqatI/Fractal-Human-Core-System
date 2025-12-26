package com.fractal.domain.profile.candidate.contact;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.recruitment.candidate.contact.CandidateContact;
import com.fractal.domain.recruitment.candidate.contact.CandidateContactService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileContactServiceImpl implements CandidateProfileContactService {

   private final CandidateContactService contactService;
   private final AuthenticatedService authenticatedService;


    @Override
    public CandidateContact create(ContactRequest dto) {
        return contactService.create(authenticatedService.getCandidateId(),dto);
    }

    @Override
    public List<CandidateContact> getAll() {
        return contactService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateContact getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateContact update(Long id, ContactRequest dto) {
        return contactService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
        contactService.delete(authenticatedService.getCandidateId(), findById(id).getId());
    }

    @Override
    public ContactResponse toDTO(CandidateContact contact) {
        return contactService.toDTO(contact);
    }

    private CandidateContact findById(Long id) {
        System.out.println(id);
        var contact1 = contactService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(contact -> contact.getId().longValue() == id.longValue())
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        System.out.println(contact1.getId());
        return contact1;
    }
}
