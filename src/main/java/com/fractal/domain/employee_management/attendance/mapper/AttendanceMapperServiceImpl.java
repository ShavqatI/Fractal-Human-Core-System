package com.fractal.domain.employee_management.attendance.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.absence.AbsenceService;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.employee_management.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class AttendanceMapperServiceImpl implements AttendanceMapperService {

    private final StatusService statusService;
    private final EmployeeService employeeService;
    private final AbsenceService absenceService;

    @Override
    public AttendanceResponse toDTO(Attendance attendance) {
        return new AttendanceResponse(
                attendance.getId(),
                employeeService.toCompactDTO(attendance.getEmployee()),
                attendance.getDate(),
                statusService.toCompactDTO(attendance.getStatus()),
                attendance.getStartTime(),
                attendance.getEndTime(),
                attendance.getHoursWorked(),
                attendance.getOvertimeHours(),
                attendance.getRemarks(),
                Optional.ofNullable(attendance.getAbsence())
                        .map(absenceService::toDTO)
                        .orElse(null),
                attendance.getCreatedDate()
        );
    }


    @Override
    public Attendance toEntity(AttendanceRequest dto) {
        var attendance = mapToEntity(new Attendance(), dto);
        attendance.setStatus(statusService.getByCode("CREATED"));
        return attendance;
    }

    @Override
    public Attendance toEntity(AttendanceBatchRequest dto) {
        return toEntity(new AttendanceRequest(
                    dto.employeeId(),
                    dto.date(),
                    null,
                    null,
                    null,
                    null
            ));

    }

    @Override
    public Attendance toEntity(Attendance attendance, AttendanceRequest dto) {
        return mapToEntity(attendance, dto);
    }

    private Attendance mapToEntity(Attendance attendance, AttendanceRequest dto) {
        attendance.setEmployee(employeeService.getById(dto.employeeId()));
        attendance.setDate(dto.date());
        attendance.setStartTime(dto.startTime());
        attendance.setEndTime(dto.endTime());
        if(dto.startTime() != null && dto.endTime() != null) {
            attendance.setHoursWorked(Duration.between(dto.startTime(), dto.endTime()).toMinutes());
            attendance.setOvertimeHours(Duration.between(dto.startTime(), dto.endTime()).toMinutes());
        }
        attendance.setAbsence(absenceService.getById(dto.employeeId()));
        attendance.setRemarks(dto.remarks());
        return attendance;
    }
}
