package com.fractal.domain.identification_document.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record IdentificationDocumentRequest(
        Long identificationDocumentTypeId,
        String series,
        Integer number,
        LocalDate issueDate,
        LocalDate expiryDate,
        String issueOrganization,
        String issueOrganizationAddress,
        List<MultipartFile> files,
        Long statusId
) {
}
