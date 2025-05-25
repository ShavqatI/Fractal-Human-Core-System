package com.fractal.domain.employee_management.identification_document;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.employee_management.identification_document.resource.IdentificationDocumentResourceService;
import com.fractal.domain.employee_management.identification_document.type.IdentificationDocumentTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class IdentificationDocumentServiceImpl implements IdentificationDocumentService {

    private final IdentificationDocumentRepository identificationDocumentRepository;

    private final IdentificationDocumentTypeService identificationDocumentTypeService;

    private final IdentificationDocumentResourceService resourceService;

    private final StatusService statusService;

    @Override
    public IdentificationDocument create(IdentificationDocumentRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<IdentificationDocument> getAll() {
        return identificationDocumentRepository.findAll();
    }

    @Override
    public IdentificationDocument getById(Long id) {
        return findById(id);
    }

    @Override
    public IdentificationDocument update(Long id, IdentificationDocumentRequest dto) {
        try {
            var identificationDocument = findById(id);
            identificationDocument.setIdentificationDocumentType(identificationDocumentTypeService.getById(dto.identificationTypeId()));
            identificationDocument.setSeries(dto.series());
            identificationDocument.setNumber(dto.number());
            identificationDocument.setIssueDate(dto.issueDate());
            identificationDocument.setExpiryDate(dto.expiryDate());
            identificationDocument.setTermInYears((int) ChronoUnit.YEARS.between(dto.issueDate(), dto.expiryDate()));
            identificationDocument.setIssueOrganization(dto.issueOrganization());
            identificationDocument.setIssueOrganizationAddress(dto.issueOrganizationAddress());
            identificationDocument.setStatus(statusService.getById(dto.statusId()));
            dto.files().forEach(file-> identificationDocument.addResource(resourceService.toEntity(file,null)));
           return identificationDocument;
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      identificationDocumentRepository.delete(findById(id));
    }

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
    public IdentificationDocument addResource(Long id, MultipartFile file) {
        var identificationDocument = findById(id);
        identificationDocument.addResource(resourceService.toEntity(file,null));
        return save(identificationDocument);
    }

    @Override
    public IdentificationDocument updateResource(Long id, Long resourceId, MultipartFile file) {
        var identificationDocument = findById(id);
        var resource = identificationDocument.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification Document Resource  with id: " + resourceId + " not found"));
        resourceService.update(resource,resourceService.fileToRequest(file,null));
        return save(identificationDocument);
    }

    @Override
    public IdentificationDocument deleteResource(Long id, Long resourceId) {
        var identificationDocument = findById(id);
        var resource = identificationDocument.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Identification Document Resource  with id: " + resourceId + " not found"));
        resourceService.delete(resource);
      return save(identificationDocument);
    }

    private IdentificationDocument toEntity(IdentificationDocumentRequest dto) {
        var identificationDocument  = IdentificationDocument.builder()
                .identificationDocumentType(identificationDocumentTypeService.getById(dto.identificationTypeId()))
                .series(dto.series())
                .number(dto.number())
                .issueDate(dto.issueDate())
                .expiryDate(dto.expiryDate())
                .termInYears((int) ChronoUnit.YEARS.between(dto.issueDate(), dto.expiryDate()))
                .issueOrganization(dto.issueOrganization())
                .issueOrganizationAddress(dto.issueOrganizationAddress())
                .status(statusService.getById(dto.statusId()))
                .build();
        dto.files().forEach(file-> identificationDocument.addResource(resourceService.toEntity(file,null)));
        return identificationDocument;
    }

    private IdentificationDocument save(IdentificationDocument identificationDocument) {
        try {
            return identificationDocumentRepository.save(identificationDocument);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private IdentificationDocument findById(Long id) {
        return identificationDocumentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Identification Document with id: " + id + " not found"));
    }
}
