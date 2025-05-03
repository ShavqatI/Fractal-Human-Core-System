package com.fractal.domain.organization_management.organization_unit;

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
    public OrganizationUnitDto create(OrganizationUnitDto dto) {
        try {
            return toDTO(save(toEntity(dto)));
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    public List<OrganizationUnitDto> getAll() {
        return organizationUnitRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrganizationUnitDto getByCode(String code) {
        return toDTO(organizationUnitRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Organization Unit with code: " + code + " not found")));
    }

    @Override
    public OrganizationUnit findByCode(String code) {
        return organizationUnitRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Organization Unit with code: " + code + " not found"));
    }

    @Override
    public OrganizationUnitDto getById(Long id) {
        return toDTO(findById(id));
    }

    @Override
    public OrganizationUnitDto update(Long id, OrganizationUnitDto dto) {
        try {
            OrganizationUnit organizationUnit = findById(id);
            organizationUnit.setCode(dto.code());
            organizationUnit.setName(dto.name());
            organizationUnit.setDescription(dto.description());
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
    public OrganizationUnitDto toDTO(OrganizationUnit organizationUnit) {
        return new OrganizationUnitDto(
                organizationUnit.getId(),
                organizationUnit.getCode(),
                organizationUnit.getName(),
                organizationUnit.getDescription(),
                organizationUnit.getCreatedDate()
        );
    }
    private OrganizationUnit toEntity(OrganizationUnitDto dto) {
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
