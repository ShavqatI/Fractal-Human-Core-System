package com.fractal.domain.recruitment.candidate.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.contact.mapper.CandidateContactMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateContactServiceImpl implements CandidateContactService {

    private final CandidateContactRepository contactRepository;
    private final CandidateService candidateService;
    private final CandidateContactMapperService contactMapperService;


    @Override
    @Transactional
    public CandidateContact create(Long candidateId, ContactRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var contact = contactMapperService.toEntity(dto);
        candidate.addContact(contact);
        candidateService.save(candidate);
        return contact;
    }

    @Override
    public List<CandidateContact> getAllByCandidateId(Long candidateId) {
        return contactRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateContact getById(Long candidateId, Long id) {
        return contactRepository.findByCandidateIdAndId(candidateId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public CandidateContact update(Long candidateId, Long id, ContactRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var contact = candidate.getContacts()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        contact = contactMapperService.toEntity(contact, dto);
        contactRepository.save(contact);
        candidateService.save(candidate);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long candidateId, Long id) {
        System.out.println("income id " + id);
        var candidate = candidateService.getById(candidateId);
        var contact = candidate.getContacts()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        System.out.println("found id" + contact.getId());
        candidate.removeContact(contact);
        candidateService.save(candidate);
    }

    @Override
    public ContactResponse toDTO(CandidateContact contact) {
        return contactMapperService.toDTO(contact);
    }

}
