package com.fractal.domain.organization_management.organization;

import com.fractal.domain.organization_management.organization.address.OrganizationAddressService;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
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
    private final OrganizationAddressService organizationAddressService;

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
            organization.setParent(organizationRepository.findByCode(dto.parent()).orElse(null));
            organization.setOrganizationUnit(organizationUnitService.getByCode(dto.organizationUnit()));
            dto.addresses().forEach(organizationAddressRequest -> organization.addAddress(organizationAddressService.toEntity(organizationAddressRequest)));
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
                Optional.ofNullable(organization.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(organization.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(organizationAddressService::toDTO)
                        .collect(Collectors.toList()),
                organization.getCreatedDate()
        );
    }

    @Override
    public Organization addAddress(Long id, OrganizationAddressRequest dto) {
        Organization organization = findById(id);
        organization.addAddress(organizationAddressService.toEntity(dto));
        return save(organization);
    }

    @Override
    public Organization updateAddress(Long id, Long addressId, OrganizationAddressRequest dto) {
        Organization organization = findById(id);
        var address = organization.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + addressId + " not found"));
        organizationAddressService.update(address,dto);
        return save(organization);
    }

    @Override
    public Organization deleteAddress(Long id, Long addressId) {
        Organization organization = findById(id);
        var address = organization.getAddresses()
                .stream()
                .filter(a-> a.getId().equals(addressId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization address with id: " + addressId + " not found"));
        organizationAddressService.delete(address);
      return save(organization);
    }

    private Organization toEntity(OrganizationRequest dto) {
        Organization organization = Organization.builder()
                .code(dto.code())
                .fullName(dto.fullName())
                .name(dto.name())
                .tinNumber(dto.tinNumber())
                .openDate(dto.openDate())
                .closeDate(dto.closeDate())
                .level(dto.level())
                .levelMap(dto.levelMap())
                .parent(organizationRepository.findByCode(dto.parent()).orElse(null))
                .organizationUnit(organizationUnitService.getByCode(dto.organizationUnit()))
                .build();
        dto.addresses().forEach(organizationAddress-> organization.addAddress(organizationAddressService.toEntity(organizationAddress)));
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
