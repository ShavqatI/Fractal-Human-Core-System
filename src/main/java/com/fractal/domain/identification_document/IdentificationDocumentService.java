package com.fractal.domain.identification_document;

import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;

public interface IdentificationDocumentService {

    /*IdentificationDocument create(Long employeeId, IdentificationDocumentRequest dto);
    IdentificationDocument update(Long employeeId, Long id, IdentificationDocumentRequest dto);
    void delete(Long employeeId,Long id);
    List<IdentificationDocument> getAllByEmployeeId(Long employeeId);
    IdentificationDocument getById(Long employeeId , Long id);*/
    IdentificationDocument getById(Long id);
    IdentificationDocument save(IdentificationDocument identificationDocument);
    IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument);


}
