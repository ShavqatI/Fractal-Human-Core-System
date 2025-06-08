package com.fractal.domain.organization_management.organization;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.organization_management.organization.address.OrganizationAddressService;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.contact.OrganizationContactService;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import com.fractal.domain.organization_management.unit.OrganizationUnitService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationUnitService organizationUnitService;
    private final OrganizationAddressService addressService;
    private final OrganizationContactService contactService;

    @Override
    public Organization create(OrganizationRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getByCode(String code) {
        return organizationRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Organization with code: " + code + " not found"));

    }

    @Override
    public Organization getById(Long id) {
        return findById(id);
    }

    @Override
    public Organization update(Long id, OrganizationRequest dto) {
        try {
            Organization organization = findById(id);
            organization.setCode(dto.code());
            organization.setName(dto.name());
            organization.setFullName(dto.fullName());
            organization.setTinNumber(dto.tinNumber());
            organization.setOpenDate(dto.openDate());
            organization.setCloseDate(dto.closeDate());
            organization.setLevel(dto.level());
            organization.setLevelMap(dto.levelMap());
            organization.setLevelMap(dto.levelMap());
            organization.setOrganizationUnit(organizationUnitService.getByCode(dto.organizationUnit()));
            dto.addresses().forEach(address -> organization.addAddress(addressService.toEntity(address)));
            dto.contacts().forEach(contact -> organization.addContact(contactService.toEntity(contact)));
            dto.children().forEach(child->organization.addChild(toEntity(child)));
           return save(organization);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    public void deleteById(Long id) {
      organizationRepository.delete(findById(id));
    }

    @Override
    public OrganizationResponse toDTO(Organization organization) {
        return new OrganizationResponse(
                organization.getId(),
                organization.getCode(),
                organization.getName(),
                organization.getFullName(),
                organization.getTinNumber(),
                organization.getOpenDate(),
                organization.getCloseDate(),
                organization.getLevel(),
                organization.getLevelMap(),
                organization.getOrganizationUnit().getName(),
                Optional.ofNullable(organization.getParent())
                        .map(Organization::getName)
                        .orElse(null),
                Optional.ofNullable(organization.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(organization.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(organization.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                organization.getCreatedDate()
        );
    }

    @Override
    public Organization addAddress(Long id, OrganizationAddressRequest dto) {
        var organization = findById(id);
        organization.addAddress(addressService.toEntity(dto));
        return save(organization);
    }

    @Override
    public Organization updateAddress(Long id, Long addressId, OrganizationAddressRequest dto) {
        var organization = findById(id);
        var address = organization.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + addressId + " not found"));
        addressService.update(address,dto);
        return save(organization);
    }

    @Override
    public Organization deleteAddress(Long id, Long addressId) {
        var organization = findById(id);
        var address = organization.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + addressId + " not found"));
        organization.removeAddress(address);
        addressService.delete(address);
      return save(organization);
    }

    @Override
    public Organization addContact(Long id, ContactRequest dto) {
        var organization = findById(id);
        organization.addContact(contactService.toEntity(dto));
        return save(organization);
    }

    @Override
    public Organization updateContact(Long id, Long contactId, ContactRequest dto) {
        var organization = findById(id);
        var contact = organization.getContacts()
                .stream()
                .filter(c-> c.getId().equals(contactId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization contact with id: " + contactId + " not found"));
        contactService.update(contact.getId(),dto);
        return save(organization);
    }

    @Override
    public Organization deleteContact(Long id, Long contactId) {
        var organization = findById(id);
        var contact = organization.getContacts()
                .stream()
                .filter(c-> c.getId().equals(contactId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization contact with id: " + contactId + " not found"));
        organization.removeContact(contact);
        contactService.delete(contact);
        return save(organization);
    }

    @Override
    public Organization addChild(Long id, OrganizationRequest dto) {
        var organization = findById(id);
        var child = toEntity(dto);
        if (organization.getOrganizationUnit().equals(child.getOrganizationUnit())) {
            throw new RuntimeException("Child can not have same organization unit as parent ");
        }
        organization.addChild(child);
        return save(organization);
    }

    @Override
    public Organization updateChild(Long id, Long childId, OrganizationRequest dto) {
        var organization = findById(id);
        var child = organization.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        update(child.getId(),dto);
        return save(organization);
    }

    @Override
    public Organization deleteChild(Long id, Long childId) {
        var organization = findById(id);
        var child = organization.getChildren().stream().filter(ch-> ch.getId().equals(childId)).findFirst().orElseThrow(()->new ResourceNotFoundException("Child with id: " + childId + " not found"));
        organization.removeChild(child);
        deleteById(child.getId());
       return save(organization);
    }

    private Organization toEntity(OrganizationRequest dto) {
        var organization = Organization.builder()
                .code(dto.code())
                .fullName(dto.fullName())
                .name(dto.name())
                .tinNumber(dto.tinNumber())
                .openDate(dto.openDate())
                .closeDate(dto.closeDate())
                .level(dto.level())
                .levelMap(dto.levelMap())
                .organizationUnit(organizationUnitService.getByCode(dto.organizationUnit()))
                .build();
        dto.addresses().forEach(organizationAddress-> organization.addAddress(addressService.toEntity(organizationAddress)));
        dto.contacts().forEach(contact -> organization.addContact(contactService.toEntity(contact)));
        dto.children().forEach(child->organization.addChild(toEntity(child)));
       return organization;
    }

    private Organization save(Organization organization) {
        try {
            return organizationRepository.save(organization);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Organization findById(Long id) {
        return organizationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Organization with id: " + id + " not found"));
    }
}
