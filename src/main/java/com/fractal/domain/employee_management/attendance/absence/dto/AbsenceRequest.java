package com.fractal.domain.employee_management.attendance.absence.dto;

import java.time.LocalDate;

public record AbsenceRequest(
         Long employeeId,
         Long absenceTypeId,
         Long statusId,
         LocalDate startDate,
         LocalDate endDate,
         String reason,
         String remarks

) { }
