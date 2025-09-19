package com.fractal.domain.employee_management.attendance.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.employee_management.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
class AttendanceMapperServiceImpl implements AttendanceMapperService {

    private final StatusService statusService;
    private final EmployeeService employeeService;
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
                attendance.getCreatedDate()
        );
    }


    @Override
    public Attendance toEntity(AttendanceRequest dto) {
        return mapToEntity(new Attendance(), dto);
    }

    @Override
    public Attendance toEntity(Attendance attendance, AttendanceRequest dto) {
        return mapToEntity(attendance, dto);
    }

    private Attendance mapToEntity(Attendance attendance, AttendanceRequest dto) {
        attendance.setEmployee(employeeService.getById(dto.employeeId()));
        attendance.setDate(dto.date());
        attendance.setStatus(statusService.getById(dto.statusId()));
        attendance.setStartTime(dto.startTime());
        attendance.setEndTime(dto.endTime());
        attendance.setHoursWorked(Duration.between(dto.startTime(),dto.endTime()).toMinutes());
        attendance.setOvertimeHours(Duration.between(dto.startTime(),dto.endTime()).toMinutes());
        attendance.setRemarks(dto.remarks());
        return attendance;
    }
}
