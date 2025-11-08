package com.fractal.domain.integration.mapping.employee;

import com.fractal.domain.integration.mapping.employee.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.employee.dto.DocumentTemplateManagerResponse;
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
    public EmployeeMapping create(DocumentTemplateManagerRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<EmployeeMapping> getAll() {
        return documentTemplateManagerRepository.findAll();
    }

    @Override
    public EmployeeMapping getByCode(String code) {
        return documentTemplateManagerRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public EmployeeMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public EmployeeMapping update(Long id, DocumentTemplateManagerRequest dto) {
        try {
            EmployeeMapping employeeMapping = findById(id);
            fileService.delete(employeeMapping.getFilePath());
            employeeMapping.setCode(dto.code());
            employeeMapping.setName(dto.name());
            employeeMapping.setFilePath(fileService.save(dto.file(),resourceStoragePath));
            return save(employeeMapping);
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
    public DocumentTemplateManagerResponse toDTO(EmployeeMapping employeeMapping) {
        return new DocumentTemplateManagerResponse(
                employeeMapping.getId(),
                employeeMapping.getCode(),
                employeeMapping.getName(),
                employeeMapping.getFilePath(),
                employeeMapping.getFileFormat(),
                employeeMapping.getCreatedDate()
        );
    }

    private EmployeeMapping toEntity(DocumentTemplateManagerRequest dto) {
        return EmployeeMapping.builder()
                .code(dto.code())
                .name(dto.name())
                .filePath(fileService.save(dto.file(), resourceStoragePath))
                .build();
    }

    private EmployeeMapping save(EmployeeMapping employeeMapping) {
        try {
            return documentTemplateManagerRepository.save(employeeMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmployeeMapping findById(Long id) {
        return documentTemplateManagerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}
