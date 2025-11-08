package com.fractal.domain.integration.mapping.order_type;

import com.fractal.domain.integration.mapping.order_type.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.integration.mapping.order_type.dto.DocumentTemplateManagerResponse;

import java.util.List;

public interface DocumentTemplateManagerService {

    OrderTypeMapping create(DocumentTemplateManagerRequest dto);
    List<OrderTypeMapping> getAll();
    OrderTypeMapping getByCode(String code);
    OrderTypeMapping getById(Long id);
    OrderTypeMapping update(Long id, DocumentTemplateManagerRequest dto);
    void deleteById(Long id);
    DocumentTemplateManagerResponse toDTO(OrderTypeMapping orderTypeMapping);
}
