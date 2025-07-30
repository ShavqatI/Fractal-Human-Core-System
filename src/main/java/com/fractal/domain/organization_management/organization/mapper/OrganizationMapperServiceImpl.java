package com.fractal.domain.organization_management.organization.mapper;

import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.organization.address.mapper.OrganizationAddressMapperService;
import com.fractal.domain.organization_management.organization.contact.mapper.OrganizationContactMapperService;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import com.fractal.domain.organization_management.unit.OrganizationUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class OrganizationMapperServiceImpl implements OrganizationMapperService {

    private final OrganizationUnitService organizationUnitService;
    private final OrganizationAddressMapperService addressMapperService;
    private final OrganizationContactMapperService contactMapperService;
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
                        .map(addressMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(organization.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
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
    public OrganizationCompactResponse toCompactDTO(Organization organization) {
        return new OrganizationCompactResponse(
                organization.getId(),
                organization.getCode(),
                organization.getName()
        );
    }

    @Override
    public Organization toEntity(OrganizationRequest dto) {
        return mapToEntity(new Organization(), dto);
    }

    @Override
    public Organization toEntity(Organization organization, OrganizationRequest dto) {
        return mapToEntity(organization, dto);
    }

    private Organization mapToEntity(Organization organization,OrganizationRequest dto) {
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
        dto.addresses().forEach(address -> organization.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact -> organization.addContact(contactMapperService.toEntity(contact)));
        dto.children().forEach(child->organization.addChild(toEntity(child)));
        return organization;
    }
}
