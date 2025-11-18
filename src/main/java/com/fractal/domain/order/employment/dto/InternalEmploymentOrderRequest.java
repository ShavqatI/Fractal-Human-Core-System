package com.fractal.domain.order.employment.dto;

import com.fractal.domain.order.employment.record.dto.InternalEmploymentOrderRecordRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record InternalEmploymentOrderRequest(
        Long orderTypeId,
        List<InternalEmploymentOrderRecordRequest> records,
        String number,
        LocalDate date,
        Long statusId,
        List<MultipartFile> files

) {
}
