package com.fractal.domain.order.recognition.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record RecognitionOrderUploadExcelRequest(
        @NotNull
        Long orderTypeId,
        @NotBlank
        String number,
        @NotNull
        LocalDate date,
        @NotBlank
        String sourceDocument,
        @NotBlank
        String justification,
        LocalDate startDate,
        LocalDate endDate,
        @NotNull
        MultipartFile file
) {
}
