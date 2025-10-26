package com.fractal.domain.employee_management.business_trip.order.dto;

import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.order.type.OrderType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record BusinessTripOrderRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        Long statusId,
        List<MultipartFile> files

) {
}
