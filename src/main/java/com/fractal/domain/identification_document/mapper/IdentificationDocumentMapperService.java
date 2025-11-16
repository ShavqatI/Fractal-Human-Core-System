package com.fractal.domain.identification_document.mapper;

import com.fractal.domain.identification_document.IdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;

public interface IdentificationDocumentMapperService {
    IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument);

    IdentificationDocument toEntity(IdentificationDocumentRequest dto);

    IdentificationDocument toEntity(IdentificationDocument identificationDocument, IdentificationDocumentRequest dto);

    IdentificationDocument copy(IdentificationDocument identificationDocument);
}


