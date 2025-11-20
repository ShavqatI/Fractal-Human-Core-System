package com.fractal.domain.order.vacation.dto;

import com.fractal.domain.vacation_management.vacation.dto.VacationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record VacationOrderRequest(
        Long orderTypeId,
        VacationRequest vacation,
        String number,
        LocalDate date,
        Long statusId,
        List<MultipartFile> files
) {
}
