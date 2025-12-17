package com.fractal.domain.order.employment.dto;

import com.fractal.domain.employment.internal.dto.TerminationRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record EmploymentOrderTerminationRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        String sourceDocument,
        Long employeeId,
        TerminationRequest termination,
        List<MultipartFile> files

) {
}
