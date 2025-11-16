package com.fractal.domain.vacation_management.request.medical_info.dto;

import java.time.LocalDate;

public record VacationRequestMedicalInfoRequest(
        String certificateNumber,

        LocalDate issueDate,

        LocalDate startDate,

        LocalDate endDate,

        String doctorName,

        String medicalInstitution,

        String diagnosis,

        String notes
) {}
