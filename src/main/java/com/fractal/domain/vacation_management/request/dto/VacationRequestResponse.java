package com.fractal.domain.vacation_management.request.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.vacation_management.category.dto.VacationCategoryResponse;
import com.fractal.domain.vacation_management.order.dto.VacationOrderResponse;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoResponse;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityResponse;
import com.fractal.domain.vacation_management.request.state.VacationRequestStateResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record VacationRequestResponse(
        Long id,
        EmployeeCompactResponse employee,
        EmployeeCompactResponse successorEmployee,
        VacationTypeResponse vacationType,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,
        String description,
        List<VacationRequestResponsibilityResponse> responsibilities,
        List<VacationRequestMedicalInfoResponse> medicalInfos,
        List<VacationRequestStateResponse> states,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
