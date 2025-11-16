package com.fractal.domain.integration.mapping.organization;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.integration.mapping.organization.dto.OrganizationMappingRequest;
import com.fractal.domain.integration.mapping.organization.dto.OrganizationMappingResponse;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class OrganizationMappingServiceImpl implements OrganizationMappingService {

    private final OrganizationMappingRepository organizationMappingRepository;
    private final OrganizationService organizationService;
    private final StatusService statusService;

    @Override
    public OrganizationMapping create(OrganizationMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<OrganizationMapping> getAll() {
        return organizationMappingRepository.findAll();
    }

    @Override
    public OrganizationMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public OrganizationMapping update(Long id, OrganizationMappingRequest dto) {
        try {
            OrganizationMapping organizationMapping = findById(id);
            organizationMapping.setOrganization(organizationService.getById(dto.organizationId()));
            organizationMapping.setReferenceType(dto.referenceType());
            organizationMapping.setReference(dto.reference());
            organizationMapping.setStatus(statusService.getById(dto.statusId()));
            return save(organizationMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        organizationMappingRepository.delete(findById(id));
    }

    @Override
    public OrganizationMappingResponse toDTO(OrganizationMapping organizationMapping) {
        return new OrganizationMappingResponse(
                organizationMapping.getId(),
                organizationService.toCompactDTO(organizationMapping.getOrganization()),
                organizationMapping.getReferenceType(),
                organizationMapping.getReference(),
                statusService.toCompactDTO(organizationMapping.getStatus()),
                organizationMapping.getCreatedDate()
        );
    }

    private OrganizationMapping toEntity(OrganizationMappingRequest dto) {
        return OrganizationMapping.builder()
                .organization(organizationService.getById(dto.organizationId()))
                .referenceType(dto.referenceType())
                .reference(dto.reference())
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private OrganizationMapping save(OrganizationMapping organizationMapping) {
        try {
            return organizationMappingRepository.save(organizationMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrganizationMapping findById(Long id) {
        return organizationMappingRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
