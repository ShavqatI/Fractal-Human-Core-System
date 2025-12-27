package com.fractal.domain.profile.employee.identification_document;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocumentService;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileIdentificationDocumentServiceImpl implements ProfileIdentificationDocumentService {

   private final EmployeeIdentificationDocumentService identificationDocumentService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeIdentificationDocument> getAll() {
        return identificationDocumentService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeIdentificationDocument getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument identificationDocument) {
        return identificationDocumentService.toDTO(identificationDocument);
    }


}
