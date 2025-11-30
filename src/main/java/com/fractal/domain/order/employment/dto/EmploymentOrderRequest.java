package com.fractal.domain.order.employment.dto;

import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record EmploymentOrderRequest(
        Long orderTypeId,
        List<EmploymentOrderRecordRequest> records,
        String number,
        LocalDate date,
        List<MultipartFile> files

) {
}
