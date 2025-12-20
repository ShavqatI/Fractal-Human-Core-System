package com.fractal.domain.employee_management.attendance.dto;

import java.time.LocalDate;

public record AttendancePeriodReportRequest(LocalDate startDate, LocalDate endDate) {
}
