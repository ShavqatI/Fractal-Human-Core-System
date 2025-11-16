package com.fractal.domain.employee_management.attendance.mapper;

import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;

public interface AttendanceMapperService {
    AttendanceResponse toDTO(Attendance attendance);

    Attendance toEntity(AttendanceRequest dto);

    Attendance toEntity(Attendance attendance, AttendanceRequest dto);
}


