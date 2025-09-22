package com.fractal.domain.training_management.trainer.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.training_management.trainer.external.ExternalTrainerService;
import com.fractal.domain.training_management.trainer.external.contact.mapper.ExternalTrainerContactMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalTrainerContactServiceImpl implements ExternalTrainerContactService {

    private final ExternalTrainerContactRepository contactRepository;
    private final ExternalTrainerService trainerService;
    private final ExternalTrainerContactMapperService contactMapperService;


    @Override
    @Transactional
    public ExternalTrainerContact create(Long trainerId, ContactRequest dto) {
        var trainer = trainerService.getById(trainerId);
        var contact = contactMapperService.toEntity(dto);
        trainer.addContact(contact);
        trainerService.save(trainer);
        return contact;
    }

    @Override
    public List<ExternalTrainerContact> getAllByExternalTrainerId(Long trainerId) {
        return contactRepository.findAllByExternalTrainerId(trainerId);
    }

    @Override
    public ExternalTrainerContact getById(Long trainerId, Long id) {
        return contactRepository.findByExternalTrainerIdAndId(trainerId,id).orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public ExternalTrainerContact update(Long trainerId, Long id, ContactRequest dto) {
        var trainer = trainerService.getById(trainerId);
        var contact = trainer.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        contact = contactMapperService.toEntity(contact,dto);
        contactRepository.save(contact);
        trainerService.save(trainer);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long trainerId, Long id) {
        var trainer = trainerService.getById(trainerId);
        var contact = trainer.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate contact with id: " + id + " not found"));
        trainer.removeContact(contact);
        trainerService.save(trainer);
    }

    @Override
    public ContactResponse toDTO(ExternalTrainerContact contact) {
        return contactMapperService.toDTO(contact);
    }

}
