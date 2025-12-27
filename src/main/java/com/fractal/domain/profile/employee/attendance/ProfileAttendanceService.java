package com.fractal.domain.profile.employee.attendance;

import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;

import java.util.List;

public interface ProfileAttendanceService {
    List<Attendance> getAll();
    Attendance getById(Long id);
    AttendanceResponse toDTO(Attendance attendance);


}
