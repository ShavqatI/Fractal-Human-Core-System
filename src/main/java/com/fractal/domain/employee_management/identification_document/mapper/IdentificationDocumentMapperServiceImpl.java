package com.fractal.domain.employee_management.identification_document.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.employee_management.identification_document.resource.IdentificationDocumentResourceService;
import com.fractal.domain.employee_management.identification_document.type.IdentificationDocumentTypeService;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class IdentificationDocumentMapperServiceImpl implements IdentificationDocumentMapperService {

    private final IdentificationDocumentTypeService identificationDocumentTypeService;
    private final IdentificationDocumentResourceService resourceService;
    private final StatusService statusService;

    @Override
    public IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument) {
        return new IdentificationDocumentResponse(
                identificationDocument.getId(),
                identificationDocument.getIdentificationDocumentType().getName(),
                identificationDocument.getSeries(),
                identificationDocument.getNumber(),
                identificationDocument.getIssueDate(),
                identificationDocument.getExpiryDate(),
                identificationDocument.getTermInYears(),
                identificationDocument.getIssueOrganization(),
                identificationDocument.getIssueOrganizationAddress(),
                identificationDocument.getStatus().getName(),
                Optional.ofNullable(identificationDocument.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceService::toDTO)
                        .collect(Collectors.toList()),
                identificationDocument.getCreatedDate()
        );
    }

    @Override
    public IdentificationDocument toEntity(IdentificationDocumentRequest dto) {
        return mapToEntity(new IdentificationDocument(),dto);
    }

    @Override
    public IdentificationDocument toEntity(IdentificationDocument identificationDocument, IdentificationDocumentRequest dto) {
       return mapToEntity(identificationDocument,dto);
    }

    private IdentificationDocument mapToEntity(IdentificationDocument identificationDocument, IdentificationDocumentRequest dto) {
        identificationDocument.setIdentificationDocumentType(identificationDocumentTypeService.getById(dto.identificationTypeId()));
        identificationDocument.setSeries(dto.series());
        identificationDocument.setNumber(dto.number());
        identificationDocument.setIssueDate(dto.issueDate());
        identificationDocument.setExpiryDate(dto.expiryDate());
        identificationDocument.setTermInYears((int) ChronoUnit.YEARS.between(dto.issueDate(), dto.expiryDate()));
        identificationDocument.setIssueOrganization(dto.issueOrganization());
        identificationDocument.setIssueOrganizationAddress(dto.issueOrganizationAddress());
        identificationDocument.setStatus(statusService.getById(dto.statusId()));
        //dto.files().forEach(file-> identificationDocument.addResource(resourceService.toEntity(file,null)));
        return identificationDocument;
    }

}
