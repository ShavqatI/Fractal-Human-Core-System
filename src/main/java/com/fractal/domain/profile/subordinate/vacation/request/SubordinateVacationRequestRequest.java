package com.fractal.domain.profile.subordinate.vacation.request;

import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationRequest;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record SubordinateVacationRequestRequest(
        Long successorEmployeeId,
        @NotNull
        Long vacationTypeId,
        @NotNull
        LocalDate startDate,
        @NotNull
        Integer days,
        List<VacationRequestResponsibilityRequest> responsibilities,
        List<VacationRequestMedicalInfoRequest> medicalInfos,
        List<VacationRequestEducationRequest> educations,
        String description
) {
}