package com.fractal.controller.report.attendance;


import com.fractal.domain.report.attendance.AttendanceReportPeriodRequest;
import com.fractal.domain.report.attendance.AttendanceReportService;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/api/v1/report-management/attendance")
@RequiredArgsConstructor
public class AttendanceReportController {

    private final AttendanceReportService attendanceReportService;
    private final FileService fileService;

    @PostMapping("by-period")
    @CrossOrigin(value = "*")
    public ResponseEntity<Resource> byPeriod(@RequestBody @Valid AttendanceReportPeriodRequest dto) {
        Path path = attendanceReportService.byPeriod(dto);
        return fileService.download(path);
    }
}
