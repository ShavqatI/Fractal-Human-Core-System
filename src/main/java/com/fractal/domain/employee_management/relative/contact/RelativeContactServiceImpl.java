package com.fractal.domain.employee_management.relative.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.relative.RelativeService;
import com.fractal.domain.employee_management.relative.contact.mapper.RelativeContactMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelativeContactServiceImpl implements RelativeContactService {

    private final RelativeContactRepository contactRepository;
    private final RelativeContactMapperService contactMapperService;
    private final RelativeService relativeService;

    @Override
    public RelativeContact create(Long relativeId, ContactRequest dto) {
        var relative = relativeService.getById(relativeId);
        var contact = contactMapperService.toEntity(dto);
        relative.addContact(contact);
        relativeService.save(relative);
        return contact;
    }

    @Override
    public List<RelativeContact> getAllByRelativeId(Long relativeId) {
        return contactRepository.findAllByRelativeId(relativeId);
    }

    @Override
    public RelativeContact getById(Long relativeId, Long id) {
        return contactRepository.findByRelativeIdAndId(relativeId, id).orElseThrow(() -> new ResourceNotFoundException("Relative contact with id: " + id + " not found"));
    }

    @Override
    public RelativeContact update(Long relativeId, Long id, ContactRequest dto) {
        var relative = relativeService.getById(relativeId);
        var contact = relative.getContacts()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Relative contact with id: " + id + " not found"));
        contact = contactRepository.save(contactMapperService.toEntity(contact, dto));
        relativeService.save(relative);
        return contact;
    }

    @Override
    public void delete(Long relativeId, Long id) {
        var relative = relativeService.getById(relativeId);
        var contact = relative.getContacts()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Relative contact with id: " + id + " not found"));
        relative.removeContact(contact);
        contactRepository.delete(contact);
        relativeService.save(relative);
    }

    @Override
    public ContactResponse toDTO(RelativeContact contact) {
        return contactMapperService.toDTO(contact);
    }
}
