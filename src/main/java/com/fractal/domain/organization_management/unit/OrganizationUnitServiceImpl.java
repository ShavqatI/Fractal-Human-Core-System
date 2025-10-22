package com.fractal.domain.organization_management.unit;

import com.fractal.domain.organization_management.unit.dto.OrganizationUnitRequest;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OrganizationUnitServiceImpl  implements OrganizationUnitService {

    private final OrganizationUnitRepository organizationUnitRepository;
    @Override
    public OrganizationUnit create(OrganizationUnitRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<OrganizationUnit> getAll() {
        return organizationUnitRepository.findAll();
    }

    @Override
    public OrganizationUnit getByCode(String code) {
        return findByCode(code);
    }

    private OrganizationUnit findByCode(String code) {
        return organizationUnitRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Organization Unit with code: " + code + " not found"));
    }

    @Override
    public OrganizationUnit getById(Long id) {
        return findById(id);
    }

    @Override
    public OrganizationUnit update(Long id, OrganizationUnitRequest dto) {
        try {
            OrganizationUnit organizationUnit = findById(id);
            organizationUnit.setCode(dto.code());
            organizationUnit.setName(dto.name());
            organizationUnit.setDescription(dto.description());
            organizationUnit.setLevel(dto.level());
            return save(organizationUnit);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        organizationUnitRepository.delete(findById(id));
    }
    public OrganizationUnitResponse toDTO(OrganizationUnit organizationUnit) {
        return new OrganizationUnitResponse(
                organizationUnit.getId(),
                organizationUnit.getCode(),
                organizationUnit.getName(),
                organizationUnit.getDescription(),
                organizationUnit.getLevel(),
                organizationUnit.getCreatedDate()
        );
    }
    private OrganizationUnit toEntity(OrganizationUnitRequest dto) {
        return OrganizationUnit.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    private OrganizationUnit save(OrganizationUnit organizationUnit) {
        try {
            return organizationUnitRepository.save(organizationUnit);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    private OrganizationUnit findById(Long id) {
        return organizationUnitRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Organization Unit with id: " + id + " not found"));
    }

}
