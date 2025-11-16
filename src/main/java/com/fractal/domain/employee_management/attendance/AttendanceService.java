package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;

import java.util.List;

public interface AttendanceService {
    Attendance create(AttendanceRequest dto);

    List<Attendance> getAll();

    Attendance getById(Long id);

    List<Attendance> getAllByEmployeeId(Long employeeId);

    Attendance update(Long id, AttendanceRequest dto);

    void deleteById(Long id);

    AttendanceResponse toDTO(Attendance attendance);
}
