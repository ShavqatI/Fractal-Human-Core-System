package com.fractal.domain.vacation_management.request.dto;

import com.fractal.domain.vacation_management.order.dto.VacationOrderRequest;
import com.fractal.domain.vacation_management.request.medical_info.VacationRequestMedicalInfo;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.responsibility.VacationRequestResponsibility;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record VacationRequestRequest(
        @NotNull
    Long employeeId,
        @NotNull
    Long successorEmployeeId,
        @NotNull
    Long vacationTypeId,
        @NotNull
    LocalDate startDate,
        @NotNull
    LocalDate endDate,
    List<VacationRequestResponsibilityRequest> responsibilities,
    List<VacationRequestMedicalInfoRequest> medicalInfos,
    String description
    )

{}