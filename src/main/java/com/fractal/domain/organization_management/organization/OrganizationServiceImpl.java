package com.fractal.domain.organization_management.organization;

import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;
import com.fractal.domain.organization_management.organization.mapper.OrganizationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapperService mapperService;

    @Override
    @Transactional
    public Organization create(OrganizationRequest dto) {
        return save(mapperService.toEntity(dto));
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
    @Transactional
    public Organization update(Long id, OrganizationRequest dto) {
        try {
            Organization organization = mapperService.toEntity(findById(id),dto);
            return save(organization);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      organizationRepository.delete(findById(id));
    }

    @Override
    public OrganizationResponse toDTO(Organization organization) {
        return mapperService.toDTO(organization);
    }

    @Override
    public OrganizationCompactResponse toCompactDTO(Organization organization) {
        return mapperService.toCompactDTO(organization);
    }

    @Override
    @Transactional
    public Organization addChild(Long id, OrganizationRequest dto) {
        var organization = findById(id);
        var child = mapperService.toEntity(dto);
        if (organization.getOrganizationUnit().equals(child.getOrganizationUnit())) {
            throw new RuntimeException("Child can not have same organization unit as parent ");
        }
        organization.addChild(child);
        return save(organization);
    }

    @Override
    @Transactional
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
       return save(organization);
    }
    @Override
    @Transactional
    public Organization save(Organization organization) {
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
