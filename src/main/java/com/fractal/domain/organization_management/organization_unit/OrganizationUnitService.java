package com.fractal.domain.organization_management.organization_unit;

import java.util.List;

public interface OrganizationUnitService {
    OrganizationUnitDto create(OrganizationUnitDto dto);
    List<OrganizationUnitDto> getAll();
    OrganizationUnitDto getByCode(String code);
    OrganizationUnit findByCode(String code);
    OrganizationUnitDto getById(Long id);
    OrganizationUnitDto update(Long id, OrganizationUnitDto addressTypeDTO);
    void deleteById(Long id);
    OrganizationUnitDto toDTO(OrganizationUnit organizationUnit);
}
