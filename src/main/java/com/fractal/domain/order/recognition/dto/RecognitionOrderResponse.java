package com.fractal.domain.order.recognition.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record RecognitionOrderResponse(
        Long id,
        OrderTypeResponse orderType,
        List<RecognitionOrderRecordResponse> records,
        String number,
        LocalDate date,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
