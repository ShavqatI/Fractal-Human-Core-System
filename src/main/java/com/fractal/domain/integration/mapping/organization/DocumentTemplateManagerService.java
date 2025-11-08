package com.fractal.domain.integration.mapping.organization;

import com.fractal.domain.integration.mapping.organization.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.organization.dto.DocumentTemplateManagerResponse;

import java.util.List;

public interface DocumentTemplateManagerService {

    OrganizationMapping create(DocumentTemplateManagerRequest dto);
    List<OrganizationMapping> getAll();
    OrganizationMapping getByCode(String code);
    OrganizationMapping getById(Long id);
    OrganizationMapping update(Long id, DocumentTemplateManagerRequest dto);
    void deleteById(Long id);
    DocumentTemplateManagerResponse toDTO(OrganizationMapping organizationMapping);
}
