package com.fractal.domain.training_management.participant.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.training_management.participant.external.ExternalParticipantService;
import com.fractal.domain.training_management.participant.external.contact.mapper.ExternalParticipantContactMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalParticipantContactServiceImpl implements ExternalParticipantContactService {

    private final ExternalParticipantContactRepository contactRepository;
    private final ExternalParticipantService participantService;
    private final ExternalParticipantContactMapperService contactMapperService;


    @Override
    @Transactional
    public ExternalParticipantContact create(Long trainerId, ContactRequest dto) {
        var participant = participantService.getById(trainerId);
        var contact = contactMapperService.toEntity(dto);
        participant.addContact(contact);
        participantService.save(participant);
        return contact;
    }

    @Override
    public List<ExternalParticipantContact> getAllByExternalTrainerId(Long trainerId) {
        return contactRepository.findAllByExternalParticipantId(trainerId);
    }

    @Override
    public ExternalParticipantContact getById(Long trainerId, Long id) {
        return contactRepository.findByExternalParticipantIdAndId(trainerId,id).orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public ExternalParticipantContact update(Long trainerId, Long id, ContactRequest dto) {
        var participant = participantService.getById(trainerId);
        var contact = participant.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        contact = contactMapperService.toEntity(contact,dto);
        contactRepository.save(contact);
        participantService.save(participant);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long trainerId, Long id) {
        var participant = participantService.getById(trainerId);
        var contact = participant.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        participant.removeContact(contact);
        participantService.save(participant);
    }

    @Override
    public ContactResponse toDTO(ExternalParticipantContact contact) {
        return contactMapperService.toDTO(contact);
    }

}
