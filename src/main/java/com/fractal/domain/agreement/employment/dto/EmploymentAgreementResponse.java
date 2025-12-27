package com.fractal.domain.agreement.employment.dto;

import com.fractal.domain.agreement.type.dto.AgreementTypeResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EmploymentAgreementResponse(
        Long id,
        AgreementTypeResponse agreementType,
        LocalDate date,
        String number,
        LocalDate startDate,
        LocalDate endDate,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) {
}
