package com.fractal.domain.employee_management.relative;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.marital_status.MaritalStatusService;
import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.employee_management.relative.address.RelativeAddressService;
import com.fractal.domain.employee_management.relative.address.dto.RelativeAddressRequest;
import com.fractal.domain.employee_management.relative.contact.RelativeContactService;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.employee_management.relative.type.RelationTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class RelativeServiceImpl implements RelativeService {

    private final RelativeRepository relativeRepository;
    private final RelationTypeService relationTypeService;
    private final GenderService genderService;
    private final MaritalStatusService maritalStatusService;
    private final NationalityService nationalityService;
    private final RelativeAddressService addressService;
    private final RelativeContactService contactService;

    @Override
    public Relative create(RelativeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public RelativeResponse toDTO(Relative relative) {
        return new RelativeResponse(
                relative.getId(),
                relative.getLastName(),
                relative.getFirstName(),
                relative.getPatronymicName(),
                relative.getBirthDate(),
                relative.getTin(),
                relative.getSsn(),
                relative.getGender().getName(),
                relative.getMaritalStatus().getName(),
                relative.getNationality().getName(),
                relative.getRelationType().getName(),
                Optional.ofNullable(relative.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(relative.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactService::toDTO)
                        .collect(Collectors.toList()),
                relative.getCreatedDate()
        );
    }

    @Override
    public Relative toEntity(RelativeRequest dto) {
        var relative = Relative.builder()
                        .lastName(dto.lastName())
                        .firstName(dto.firstName())
                        .patronymicName(dto.patronymicName())
                        .birthDate(dto.birthDate())
                        .tin(dto.tin())
                        .ssn(dto.ssn())
                        .gender(genderService.getById(dto.genderId()))
                        .maritalStatus(maritalStatusService.getById(dto.maritalStatusId()))
                        .nationality(nationalityService.getById(dto.nationalityId()))
                        .relationType(relationTypeService.getById(dto.relationTypeId()))
                       .build();
        dto.addresses().forEach(address->relative.addAddress(addressService.toEntity(address)));
        dto.contacts().forEach(contact->relative.addContact(contactService.toEntity(contact)));
        return relative;
    }

    @Override
    public Relative update(Long id, RelativeRequest dto) {
       var relative = findById(id);
        relative.setLastName(dto.lastName());
        relative.setFirstName(dto.firstName());
        relative.setPatronymicName(dto.patronymicName());
        relative.setBirthDate(dto.birthDate());
        relative.setTin(dto.tin());
        relative.setSsn(dto.ssn());
        relative.setGender(genderService.getById(dto.genderId()));
        relative.setMaritalStatus(maritalStatusService.getById(dto.maritalStatusId()));
        relative.setNationality(nationalityService.getById(dto.nationalityId()));
        relative.setRelationType(relationTypeService.getById(dto.relationTypeId()));
        dto.addresses().forEach(address->relative.addAddress(addressService.toEntity(address)));
        dto.contacts().forEach(contact->relative.addContact(contactService.toEntity(contact)));
       return relative;
    }

    @Override
    public void delete(Relative relative) {
       relativeRepository.delete(relative);
    }

    @Override
    public Relative addAddress(Long id, RelativeAddressRequest dto) {
        var relative = findById(id);
        relative.addAddress(addressService.toEntity(dto));
        return save(relative);
    }

    @Override
    public Relative updateAddress(Long id, Long addressId, RelativeAddressRequest dto) {
        var relative = findById(id);
        var address = relative.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative address with id: " + addressId + " not found"));
        addressService.update(address,dto);
        return save(relative);
    }

    @Override
    public Relative deleteAddress(Long id, Long addressId) {
        var relative = findById(id);
        var address = relative.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative address with id: " + addressId + " not found"));
        relative.removeAddress(address);
        addressService.delete(address);
        return save(relative);
    }

    @Override
    public Relative addContact(Long id, ContactRequest dto) {
        var relative = findById(id);
        relative.addContact(contactService.toEntity(dto));
        return save(relative);
    }

    @Override
    public Relative updateContact(Long id, Long contactId, ContactRequest dto) {
        var relative = findById(id);
        var contact = relative.getContacts()
                .stream()
                .filter(c-> c.getId().equals(contactId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative contact with id: " + contactId + " not found"));
        contactService.update(contact.getId(),dto);
        return save(relative);
    }

    @Override
    public Relative deleteContact(Long id, Long contactId) {
        var relative = findById(id);
        var contact = relative.getContacts()
                .stream()
                .filter(c-> c.getId().equals(contactId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Relative contact with id: " + contactId + " not found"));
        relative.removeContact(contact);
        contactService.delete(contact);
        return save(relative);
    }

    private Relative save(Relative relative) {
        try {
            return relativeRepository.save(relative);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Relative findById(Long id) {
        return relativeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Relative with id: " + id + " not found"));
    }
}
