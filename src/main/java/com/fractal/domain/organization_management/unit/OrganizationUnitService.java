package com.fractal.domain.organization_management.unit;

import com.fractal.domain.organization_management.unit.dto.OrganizationUnitCreate;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;

import java.util.List;

public interface OrganizationUnitService {
    OrganizationUnit create(OrganizationUnitCreate dto);
    List<OrganizationUnit> getAll();
    OrganizationUnit getByCode(String code);
    OrganizationUnit getById(Long id);
    OrganizationUnit update(Long id, OrganizationUnitCreate addressTypeDTO);
    void deleteById(Long id);
    OrganizationUnitResponse toDTO(OrganizationUnit organizationUnit);
}
