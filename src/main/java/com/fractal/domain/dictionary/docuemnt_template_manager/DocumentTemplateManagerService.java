package com.fractal.domain.dictionary.docuemnt_template_manager;

import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerResponse;

import java.util.List;

public interface DocumentTemplateManagerService {

    DocumentTemplateManager create(DocumentTemplateManagerRequest dto);

    List<DocumentTemplateManager> getAll();

    DocumentTemplateManager getByCode(String code);

    DocumentTemplateManager getById(Long id);

    DocumentTemplateManager update(Long id, DocumentTemplateManagerRequest dto);

    void deleteById(Long id);

    DocumentTemplateManagerResponse toDTO(DocumentTemplateManager documentTemplateManager);
}
