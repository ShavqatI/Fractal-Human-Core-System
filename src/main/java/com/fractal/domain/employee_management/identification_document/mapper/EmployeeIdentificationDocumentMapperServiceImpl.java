package com.fractal.domain.employee_management.identification_document.mapper;

import com.fractal.domain.employee_management.identification_document.EmployeeIdentificationDocument;
import com.fractal.domain.identification_document.IdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.identification_document.mapper.IdentificationDocumentMapperService;
import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.resource.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeIdentificationDocumentMapperServiceImpl implements EmployeeIdentificationDocumentMapperService {

    private final IdentificationDocumentMapperService mapperService;

    @Override
    public IdentificationDocumentResponse toDTO(EmployeeIdentificationDocument identificationDocument) {
        return mapperService.toDTO(identificationDocument);
    }

    @Override
    public EmployeeIdentificationDocument toEntity(IdentificationDocumentRequest dto) {
        return convert(new EmployeeIdentificationDocument(),mapperService.toEntity(dto));
    }

    @Override
    public EmployeeIdentificationDocument toEntity(EmployeeIdentificationDocument identificationDocument, IdentificationDocumentRequest dto) {
        return convert(identificationDocument,mapperService.toEntity(identificationDocument,dto));
    }

    @Override
    public EmployeeIdentificationDocument convert(EmployeeIdentificationDocument employeeIdentificationDocument, IdentificationDocument identificationDocument) {
        employeeIdentificationDocument.setIdentificationDocumentType(identificationDocument.getIdentificationDocumentType());
        employeeIdentificationDocument.setSeries(identificationDocument.getSeries());
        employeeIdentificationDocument.setNumber(identificationDocument.getNumber());
        employeeIdentificationDocument.setIssueDate(identificationDocument.getIssueDate());
        employeeIdentificationDocument.setExpiryDate(identificationDocument.getExpiryDate());
        employeeIdentificationDocument.setTermInYears(identificationDocument.getTermInYears());
        employeeIdentificationDocument.setIssueOrganization(identificationDocument.getIssueOrganization());
        employeeIdentificationDocument.setIssueOrganizationAddress(identificationDocument.getIssueOrganizationAddress());
        employeeIdentificationDocument.setStatus(identificationDocument.getStatus());
        employeeIdentificationDocument.setResources(identificationDocument.getResources());

        return employeeIdentificationDocument;
    }

    @Override
    public EmployeeIdentificationDocument copy(IdentificationDocument identificationDocument) {
        var employeeIdentificationDocument = convert(new EmployeeIdentificationDocument(),mapperService.copy(identificationDocument));
        List<IdentificationDocumentResource> resources = new ArrayList<>(employeeIdentificationDocument.getResources());
        employeeIdentificationDocument.setResources(new ArrayList<>());
        resources.forEach(identificationDocumentResource -> employeeIdentificationDocument.addResource(identificationDocumentResource));
       return employeeIdentificationDocument;
    }
}
