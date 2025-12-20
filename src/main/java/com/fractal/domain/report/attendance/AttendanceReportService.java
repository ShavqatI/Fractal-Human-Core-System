package com.fractal.domain.report.attendance;

import java.nio.file.Path;

public interface AttendanceReportService {
    Path byPeriod(AttendanceReportPeriodRequest dto);
}
