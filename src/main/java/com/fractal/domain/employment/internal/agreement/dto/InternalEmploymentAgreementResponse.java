package com.fractal.domain.employment.internal.agreement.dto;

import com.fractal.domain.agreement.type.dto.AgreementTypeResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InternalEmploymentAgreementResponse(
        Long id,
        AgreementTypeResponse agreementType,
        String number,
        LocalDate startDate,
        LocalDate endDate,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) {
}
