package com.fractal.domain.report.attendance;

import java.time.LocalDate;

public record AttendanceReportPeriodRequest(LocalDate startDate, LocalDate endDate) {
}
