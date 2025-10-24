package com.fractal.domain.organization_management.organization.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.organization.address.mapper.OrganizationAddressMapperService;
import com.fractal.domain.organization_management.organization.contact.mapper.OrganizationContactMapperService;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import com.fractal.domain.organization_management.organization.work_schedule.mapper.OrganizationWorkScheduleMapperService;
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
    private final OrganizationWorkScheduleMapperService workScheduleMapperService;
    private final StatusService statusService;
    @Override
    public OrganizationResponse toDTO(Organization organization) {
        return new OrganizationResponse(
                organization.getId(),
                organization.getName(),
                organization.getFullName(),
                organization.getTinNumber(),
                organization.getOpenDate(),
                organization.getOpenReason(),
                organization.getCloseDate(),
                organization.getCloseReason(),
                organization.getLevelMap(),
                organizationUnitService.toDTO(organization.getOrganizationUnit()),
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
                Optional.ofNullable(organization.getWorkSchedules())
                        .orElse(emptyList())
                        .stream()
                        .map(workScheduleMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(organization.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(organization.getStatus()),
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
        organization.setName(dto.name());
        organization.setFullName(dto.fullName());
        organization.setTinNumber(dto.tinNumber());
        organization.setOpenDate(dto.openDate());
        organization.setOpenReason(dto.openReason());
        organization.setCloseDate(dto.closeDate());
        organization.setCloseReason(dto.closeReason());
        organization.setStatus(statusService.getById(dto.statusId()));
        organization.setOrganizationUnit(organizationUnitService.getById(dto.organizationUnitId()));
        dto.addresses().forEach(address -> organization.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact -> organization.addContact(contactMapperService.toEntity(contact)));
        dto.workSchedules().forEach(workSchedule -> organization.addWorkSchedule(workScheduleMapperService.toEntity(workSchedule)));
        dto.children().forEach(child->organization.addChild(toEntity(child)));
        return organization;
    }
}
