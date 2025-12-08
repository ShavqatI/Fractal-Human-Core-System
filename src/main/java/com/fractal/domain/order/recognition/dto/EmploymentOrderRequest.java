package com.fractal.domain.order.recognition.dto;

import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record EmploymentOrderRequest(
        Long orderTypeId,
        List<RecognitionOrderRecordRequest> records,
        String number,
        LocalDate date,
        List<MultipartFile> files

) {
}
