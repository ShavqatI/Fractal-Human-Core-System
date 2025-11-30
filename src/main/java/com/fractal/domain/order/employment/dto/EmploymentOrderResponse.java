package com.fractal.domain.order.employment.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EmploymentOrderResponse(
        Long id,
        OrderTypeResponse orderType,
        List<EmploymentOrderRecordResponse> records,
        String number,
        LocalDate date,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
