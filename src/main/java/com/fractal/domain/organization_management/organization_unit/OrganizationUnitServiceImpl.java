package com.fractal.domain.organization_management.organization_unit;

import com.fractal.domain.location.address.type.AddressType;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class OrganizationUnitServiceImpl  implements OrganizationUnitService {

    private final OrganizationUnitRepository organizationUnitRepository;
    @Override
    public OrganizationUnitDTO create(OrganizationUnitDTO dto) {
        try {
            return toDTO(save(toEntity(dto)));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    public List<OrganizationUnitDTO> getAll() {
        return organizationUnitRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrganizationUnitDTO getByCode(String code) {
        return toDTO(organizationUnitRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Organization Unit with code: " + code + " not found")));
    }

    @Override
    public OrganizationUnitDTO getById(Long id) {
        return toDTO(findById(id));
    }

    @Override
    public OrganizationUnitDTO update(Long id, OrganizationUnitDTO dto) {
        try {
            OrganizationUnit newOrganizationUnit = toEntity(dto);
            OrganizationUnit organizationUnit = findById(id);
            organizationUnit.setCode(newOrganizationUnit.getCode());
            organizationUnit.setName(newOrganizationUnit.getName());
            organizationUnit.setDescription(newOrganizationUnit.getDescription());
            return toDTO(save(organizationUnit));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        organizationUnitRepository.delete(findById(id));
    }
    private OrganizationUnitDTO toDTO(OrganizationUnit organizationUnit) {
        return new OrganizationUnitDTO(
                organizationUnit.getId(),
                organizationUnit.getCode(),
                organizationUnit.getName(),
                organizationUnit.getDescription(),
                organizationUnit.getCreatedDate()
        );
    }
    private OrganizationUnit toEntity(OrganizationUnitDTO dto) {
        return OrganizationUnit.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    private OrganizationUnit save(OrganizationUnit organizationUnit) {
        return organizationUnitRepository.save(organizationUnit);
    }

    private OrganizationUnit findById(Long id) {
        return organizationUnitRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Organization Unit with id: " + id + " not found"));
    }
}
