package com.fractal.domain.order.business_trip.dto;

import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record BusinessTripOrderRequest(
        Long orderTypeId,
        List<BusinessTripOrderRecordRequest> records,
        String number,
        LocalDate date,
        String sourceDocument,
        List<MultipartFile> files

) {
}
