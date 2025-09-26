package com.fractal.domain.learning_develpment.learning.learner.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.ExternalLearnerService;
import com.fractal.domain.learning_develpment.learning.learner.external.contact.mapper.ExternalParticipantContactMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalLearnerContactServiceImpl implements ExternalLearnerContactService {

    private final ExternalLearnerContactRepository contactRepository;
    private final ExternalLearnerService learnerService;
    private final ExternalParticipantContactMapperService contactMapperService;


    @Override
    @Transactional
    public ExternalLearnerContact create(Long learnerId, ContactRequest dto) {
        var learner = learnerService.getById(learnerId);
        var contact = contactMapperService.toEntity(dto);
        learner.addContact(contact);
        learnerService.save(learner);
        return contact;
    }

    @Override
    public List<ExternalLearnerContact> getAllByExternalLearnerId(Long learnerId) {
        return contactRepository.findAllByExternalLearnerId(learnerId);
    }

    @Override
    public ExternalLearnerContact getById(Long learnerId, Long id) {
        return contactRepository.findByExternalLearnerIdAndId(learnerId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id ));
    }

    @Override
    @Transactional
    public ExternalLearnerContact update(Long learnerId, Long id, ContactRequest dto) {
        var learner = learnerService.getById(learnerId);
        var contact = learner.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id ));
        contact = contactMapperService.toEntity(contact,dto);
        contactRepository.save(contact);
        learnerService.save(learner);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long learnerId, Long id) {
        var learner = learnerService.getById(learnerId);
        var contact = learner.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id ));
        learner.removeContact(contact);
        learnerService.save(learner);
    }

    @Override
    public ContactResponse toDTO(ExternalLearnerContact contact) {
        return contactMapperService.toDTO(contact);
    }

}
