package com.fractal.domain.identification_document.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.identification_document.IdentificationDocument;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.identification_document.resource.IdentificationDocumentResource;
import com.fractal.domain.identification_document.resource.mapper.IdentificationDocumentResourceMapperService;
import com.fractal.domain.identification_document.type.IdentificationDocumentTypeService;
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
    private final IdentificationDocumentResourceMapperService resourceMapperService;
    private final StatusService statusService;

    @Override
    public IdentificationDocumentResponse toDTO(IdentificationDocument identificationDocument) {
        return new IdentificationDocumentResponse(
                identificationDocument.getId(),
                identificationDocumentTypeService.toDTO(identificationDocument.getIdentificationDocumentType()),
                identificationDocument.getSeries(),
                identificationDocument.getNumber(),
                identificationDocument.getIssueDate(),
                identificationDocument.getExpiryDate(),
                identificationDocument.getTermInYears(),
                identificationDocument.getIssueOrganization(),
                identificationDocument.getIssueOrganizationAddress(),
                statusService.toCompactDTO(identificationDocument.getStatus()),
                Optional.ofNullable(identificationDocument.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
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
        identificationDocument.setIdentificationDocumentType(identificationDocumentTypeService.getById(dto.identificationDocumentTypeId()));
        identificationDocument.setSeries(dto.series());
        identificationDocument.setNumber(dto.number());
        identificationDocument.setIssueDate(dto.issueDate());
        identificationDocument.setExpiryDate(dto.expiryDate());
        identificationDocument.setTermInYears((int) ChronoUnit.YEARS.between(dto.issueDate(), dto.expiryDate()));
        identificationDocument.setIssueOrganization(dto.issueOrganization());
        identificationDocument.setIssueOrganizationAddress(dto.issueOrganizationAddress());
        identificationDocument.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file-> identificationDocument.addResource((IdentificationDocumentResource) resourceMapperService.toEntity(file,null)));
        return identificationDocument;
    }

}
