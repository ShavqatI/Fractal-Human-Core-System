package com.fractal.domain.order.recognition.dto;

import com.fractal.domain.employee_management.employment.usecase.hire.dto.HireRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record RecognitionOrderUploadExcelRequest(
        @NotNull
        Long orderTypeId,
        @NotBlank
        String number,
        @NotNull
        LocalDate date,
        @NotBlank
        String sourceDocument,
        LocalDate startDate,
        LocalDate endDate,
        @NotNull
        MultipartFile file
) {
}
