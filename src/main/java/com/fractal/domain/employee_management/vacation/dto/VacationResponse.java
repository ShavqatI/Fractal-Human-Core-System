package com.fractal.domain.employee_management.vacation.dto;

import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.employee_management.vacation.category.VacationCategory;
import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryResponse;
import com.fractal.domain.employee_management.vacation.type.VacationType;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeResponse;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VacationResponse(
        Long id,
        String employee,
        String successorEmployee,
        VacationCategoryResponse vacationCategory,
        VacationTypeResponse vacationType,
        StatusResponse status,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,
        String orderNumber,
        LocalDate orderDate,
        String description,
        LocalDateTime createdDate
) {}
