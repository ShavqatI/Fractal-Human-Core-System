package com.fractal.domain.integration.mapping.order_type;

import com.fractal.domain.integration.mapping.order_type.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.order_type.dto.DocumentTemplateManagerResponse;
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
    public OrderTypeMapping create(DocumentTemplateManagerRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<OrderTypeMapping> getAll() {
        return documentTemplateManagerRepository.findAll();
    }

    @Override
    public OrderTypeMapping getByCode(String code) {
        return documentTemplateManagerRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public OrderTypeMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public OrderTypeMapping update(Long id, DocumentTemplateManagerRequest dto) {
        try {
            OrderTypeMapping orderTypeMapping = findById(id);
            fileService.delete(orderTypeMapping.getFilePath());
            orderTypeMapping.setCode(dto.code());
            orderTypeMapping.setName(dto.name());
            orderTypeMapping.setFilePath(fileService.save(dto.file(),resourceStoragePath));
            return save(orderTypeMapping);
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
    public DocumentTemplateManagerResponse toDTO(OrderTypeMapping orderTypeMapping) {
        return new DocumentTemplateManagerResponse(
                orderTypeMapping.getId(),
                orderTypeMapping.getCode(),
                orderTypeMapping.getName(),
                orderTypeMapping.getFilePath(),
                orderTypeMapping.getFileFormat(),
                orderTypeMapping.getCreatedDate()
        );
    }

    private OrderTypeMapping toEntity(DocumentTemplateManagerRequest dto) {
        return OrderTypeMapping.builder()
                .code(dto.code())
                .name(dto.name())
                .filePath(fileService.save(dto.file(), resourceStoragePath))
                .build();
    }

    private OrderTypeMapping save(OrderTypeMapping orderTypeMapping) {
        try {
            return documentTemplateManagerRepository.save(orderTypeMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private OrderTypeMapping findById(Long id) {
        return documentTemplateManagerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}
