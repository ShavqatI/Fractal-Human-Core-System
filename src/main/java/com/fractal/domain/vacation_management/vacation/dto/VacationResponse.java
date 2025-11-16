package com.fractal.domain.vacation_management.vacation.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.vacation_management.category.dto.VacationCategoryResponse;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record VacationResponse(
        Long id,
        EmployeeCompactResponse employee,
        VacationRequestResponse vacationRequest,
        List<VacationOrderResponse> orders,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
