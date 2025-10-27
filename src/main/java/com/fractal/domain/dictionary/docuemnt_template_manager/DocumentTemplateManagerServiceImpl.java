package com.fractal.domain.dictionary.docuemnt_template_manager;

import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class DocumentTemplateManagerServiceImpl implements DocumentTemplateManagerService {

    private final DocumentTemplateManagerRepository documentTemplateManagerRepository;

    @Override
    public DocumentTemplateManager create(DocumentTemplateManagerRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<DocumentTemplateManager> getAll() {
        return documentTemplateManagerRepository.findAll();
    }

    @Override
    public DocumentTemplateManager getByCode(String code) {
        return documentTemplateManagerRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public DocumentTemplateManager getById(Long id) {
        return findById(id);
    }

    @Override
    public DocumentTemplateManager update(Long id, DocumentTemplateManagerRequest dto) {
        try {
            DocumentTemplateManager documentTemplateManager = findById(id);
            documentTemplateManager.setCode(dto.code());
            documentTemplateManager.setName(dto.name());
            documentTemplateManager.setFilePath(dto.filePath());
            documentTemplateManager.setFileFormat(dto.fileFormat());
            return save(documentTemplateManager);
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
    public DocumentTemplateManagerResponse toDTO(DocumentTemplateManager documentTemplateManager) {
        return new DocumentTemplateManagerResponse(
                documentTemplateManager.getId(),
                documentTemplateManager.getCode(),
                documentTemplateManager.getName(),
                documentTemplateManager.getFilePath(),
                documentTemplateManager.getFileFormat(),
                documentTemplateManager.getCreatedDate()
        );
    }

    private DocumentTemplateManager toEntity(DocumentTemplateManagerRequest dto) {
        return DocumentTemplateManager.builder()
                .code(dto.code())
                .name(dto.name())
                .filePath(dto.filePath())
                .fileFormat(dto.fileFormat())
                .build();
    }

    private DocumentTemplateManager save(DocumentTemplateManager documentTemplateManager) {
        try {
            return documentTemplateManagerRepository.save(documentTemplateManager);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private DocumentTemplateManager findById(Long id) {
        return documentTemplateManagerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}
