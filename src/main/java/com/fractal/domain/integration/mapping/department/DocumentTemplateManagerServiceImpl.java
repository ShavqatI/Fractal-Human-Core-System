package com.fractal.domain.integration.mapping.department;

import com.fractal.domain.integration.mapping.department.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.department.dto.DocumentTemplateManagerResponse;
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
    public DepartmentMapping create(DocumentTemplateManagerRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<DepartmentMapping> getAll() {
        return documentTemplateManagerRepository.findAll();
    }

    @Override
    public DepartmentMapping getByCode(String code) {
        return documentTemplateManagerRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public DepartmentMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public DepartmentMapping update(Long id, DocumentTemplateManagerRequest dto) {
        try {
            DepartmentMapping departmentMapping = findById(id);
            fileService.delete(departmentMapping.getFilePath());
            departmentMapping.setCode(dto.code());
            departmentMapping.setName(dto.name());
            departmentMapping.setFilePath(fileService.save(dto.file(),resourceStoragePath));
            return save(departmentMapping);
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
    public DocumentTemplateManagerResponse toDTO(DepartmentMapping departmentMapping) {
        return new DocumentTemplateManagerResponse(
                departmentMapping.getId(),
                departmentMapping.getCode(),
                departmentMapping.getName(),
                departmentMapping.getFilePath(),
                departmentMapping.getFileFormat(),
                departmentMapping.getCreatedDate()
        );
    }

    private DepartmentMapping toEntity(DocumentTemplateManagerRequest dto) {
        return DepartmentMapping.builder()
                .code(dto.code())
                .name(dto.name())
                .filePath(fileService.save(dto.file(), resourceStoragePath))
                .build();
    }

    private DepartmentMapping save(DepartmentMapping departmentMapping) {
        try {
            return documentTemplateManagerRepository.save(departmentMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private DepartmentMapping findById(Long id) {
        return documentTemplateManagerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}
