package com.fractal.domain.contact.type;

import com.fractal.domain.contact.type.dto.ContactTypeRequest;
import com.fractal.domain.contact.type.dto.ContactTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class ContactTypeServiceImpl implements ContactTypeService {

    private final ContactTypeRepository contactTypeRepository;

    @Override
    public ContactType create(ContactTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ContactType> getAll() {
        return contactTypeRepository.findAll();
    }

    @Override
    public ContactType getByCode(String code) {
        return contactTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Contact Type with code: " + code + " not found"));
    }

    @Override
    public ContactType getById(Long id) {
        return findById(id);
    }

    @Override
    public ContactType update(Long id, ContactTypeRequest dto) {
        try {
            ContactType contactType = findById(id);
            contactType.setCode(dto.code());
            contactType.setName(dto.name());
            return save(contactType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      contactTypeRepository.delete(findById(id));
    }

    @Override
    public ContactTypeResponse toDTO(ContactType contactType) {
        return new ContactTypeResponse(
                contactType.getId(),
                contactType.getCode(),
                contactType.getName(),
                contactType.getCreatedDate()
        );
    }

    private ContactType toEntity(ContactTypeRequest dto) {
        return ContactType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private ContactType save(ContactType contactType) {
        try {
            return contactTypeRepository.save(contactType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ContactType findById(Long id) {
        return contactTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact Type with id: " + id + " not found"));
    }

}
