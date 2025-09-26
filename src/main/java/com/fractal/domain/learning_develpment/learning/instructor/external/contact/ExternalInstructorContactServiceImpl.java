package com.fractal.domain.learning_develpment.learning.instructor.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.ExternalInstructorService;
import com.fractal.domain.learning_develpment.learning.instructor.external.contact.mapper.ExternalInstructorContactMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalInstructorContactServiceImpl implements ExternalInstructorContactService {

    private final ExternalInstructorContactRepository contactRepository;
    private final ExternalInstructorService instructorService;
    private final ExternalInstructorContactMapperService contactMapperService;


    @Override
    @Transactional
    public ExternalInstructorContact create(Long instructorId, ContactRequest dto) {
        var instructor = instructorService.getById(instructorId);
        var contact = contactMapperService.toEntity(dto);
        instructor.addContact(contact);
        instructorService.save(instructor);
        return contact;
    }

    @Override
    public List<ExternalInstructorContact> getAllByExternalInstructorId(Long instructorId) {
        return contactRepository.findAllByExternalInstructorId(instructorId);
    }

    @Override
    public ExternalInstructorContact getById(Long instructorId, Long id) {
        return contactRepository.findByExternalInstructorIdAndId(instructorId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    @Transactional
    public ExternalInstructorContact update(Long instructorId, Long id, ContactRequest dto) {
        var instructor = instructorService.getById(instructorId);
        var contact = instructor.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this, id));
        contact = contactMapperService.toEntity(contact,dto);
        contactRepository.save(contact);
        instructorService.save(instructor);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long instructorId, Long id) {
        var instructor = instructorService.getById(instructorId);
        var contact = instructor.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this, id));
        instructor.removeContact(contact);
        instructorService.save(instructor);
    }

    @Override
    public ContactResponse toDTO(ExternalInstructorContact contact) {
        return contactMapperService.toDTO(contact);
    }

}
