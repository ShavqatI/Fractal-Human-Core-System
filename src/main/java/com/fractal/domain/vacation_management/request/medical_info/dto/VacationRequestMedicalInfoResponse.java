package com.fractal.domain.vacation_management.request.medical_info.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VacationRequestMedicalInfoResponse(
        Long id,
        String certificateNumber,

        LocalDate issueDate,

        LocalDate startDate,

        LocalDate endDate,

        String doctorName,

        String medicalInstitution,

        String diagnosis,

        String notes,
        LocalDateTime createdDate

) {
}
