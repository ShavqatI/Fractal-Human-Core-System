package com.fractal.domain.employee_management.vacation.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryResponse;
import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderResponse;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record VacationResponse(
        Long id,
        EmployeeCompactResponse employee,
        EmployeeCompactResponse successorEmployee,
        VacationCategoryResponse vacationCategory,
        VacationTypeResponse vacationType,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,
        String description,
        List<VacationOrderResponse> orders,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
