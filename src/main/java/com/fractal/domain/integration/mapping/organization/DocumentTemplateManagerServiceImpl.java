package com.fractal.domain.integration.mapping.organization;

import com.fractal.domain.integration.mapping.organization.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.organization.dto.DocumentTemplateManagerResponse;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class DocumentTemplateManagerServiceImpl implements DocumentTemplateManagerService {

    private final DocumentTemplateManagerRepository documentTemplateManagerRepository;
    private final FileService fileService;

    @Value("${resource-storage.document-template-manager}")
    private String resourceStoragePath;

    @Override
    public OrganizationMapping create(DocumentTemplateManagerRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<OrganizationMapping> getAll() {
        return documentTemplateManagerRepository.findAll();
    }

    @Override
    public OrganizationMapping getByCode(String code) {
        return documentTemplateManagerRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public OrganizationMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public OrganizationMapping update(Long id, DocumentTemplateManagerRequest dto) {
        try {
            OrganizationMapping organizationMapping = findById(id);
            fileService.delete(organizationMapping.getFilePath());
            organizationMapping.setCode(dto.code());
            organizationMapping.setName(dto.name());
            organizationMapping.setFilePath(fileService.save(dto.file(),resourceStoragePath));
            return save(organizationMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        documentTemplateManagerRepository.delete(findById(id));
    }

    @Override
    public DocumentTemplateManagerResponse toDTO(OrganizationMapping organizationMapping) {
        return new DocumentTemplateManagerResponse(
                organizationMapping.getId(),
                organizationMapping.getCode(),
                organizationMapping.getName(),
                organizationMapping.getFilePath(),
                organizationMapping.getFileFormat(),
                organizationMapping.getCreatedDate()
        );
    }

    private OrganizationMapping toEntity(DocumentTemplateManagerRequest dto) {
        return OrganizationMapping.builder()
                .code(dto.code())
                .name(dto.name())
                .filePath(fileService.save(dto.file(), resourceStoragePath))
                .build();
    }

    private OrganizationMapping save(OrganizationMapping organizationMapping) {
        try {
            return documentTemplateManagerRepository.save(organizationMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrganizationMapping findById(Long id) {
        return documentTemplateManagerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}
