package com.fractal.domain.organization_management.organization_unit;

import java.util.List;

public interface OrganizationUnitService {
    OrganizationUnitDTO create(OrganizationUnitDTO dto);
    List<OrganizationUnitDTO> getAll();
    OrganizationUnitDTO getByCode(String code);
    OrganizationUnitDTO getById(Long id);
    OrganizationUnitDTO update(Long id,OrganizationUnitDTO addressTypeDTO);
    void deleteById(Long id);
}
