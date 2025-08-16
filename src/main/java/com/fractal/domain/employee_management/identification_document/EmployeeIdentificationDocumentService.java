package com.fractal.domain.employee_management.identification_document;

import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;

import java.util.List;

public interface EmployeeIdentificationDocumentService {

    EmployeeIdentificationDocument create(Long employeeId, IdentificationDocumentRequest dto);
    EmployeeIdentificationDocument update(Long employeeId, Long id, IdentificationDocumentRequest dto);
    void delete(Long employeeId,Long id);
    List<EmployeeIdentificationDocument> getAllByEmployeeId(Long employeeId);
    EmployeeIdentificationDocument getById(Long employeeId , Long id);
    EmployeeIdentificationDocument getById(Long id);
    IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument employeeIdentificationDocument);


}
