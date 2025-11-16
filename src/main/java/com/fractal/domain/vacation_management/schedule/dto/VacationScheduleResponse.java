package com.fractal.domain.vacation_management.schedule.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.vacation_management.category.dto.VacationCategoryResponse;
import com.fractal.domain.vacation_management.order.dto.VacationOrderResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record VacationScheduleResponse(
        Long id,
        EmployeeCompactResponse employee,
        VacationTypeResponse vacationType,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
