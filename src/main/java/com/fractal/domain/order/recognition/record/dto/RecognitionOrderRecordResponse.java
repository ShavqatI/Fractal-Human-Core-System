package com.fractal.domain.order.recognition.record.dto;

import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentResponse;

import java.time.LocalDateTime;

public record RecognitionOrderRecordResponse(
        Long id,
        EmployeeCompactResponse employee,
        EmploymentResponse employment,
        LocalDateTime createdDate

) {
}
