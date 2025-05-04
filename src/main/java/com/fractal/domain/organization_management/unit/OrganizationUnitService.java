package com.fractal.domain.organization_management.unit;

import com.fractal.domain.organization_management.unit.dto.OrganizationUnitRequest;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;

import java.util.List;

public interface OrganizationUnitService {
    OrganizationUnit create(OrganizationUnitRequest dto);
    List<OrganizationUnit> getAll();
    OrganizationUnit getByCode(String code);
    OrganizationUnit getById(Long id);
    OrganizationUnit update(Long id, OrganizationUnitRequest addressTypeDTO);
    void deleteById(Long id);
    OrganizationUnitResponse toDTO(OrganizationUnit organizationUnit);
}
