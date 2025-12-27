package com.fractal.domain.profile.employee.attendance;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.AttendanceService;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileAttendanceServiceImpl implements ProfileAttendanceService {

   private final AttendanceService attendanceService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<Attendance> getAll() {
        return attendanceService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public Attendance getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public AttendanceResponse toDTO(Attendance attendance) {
        return attendanceService.toDTO(attendance);
    }


}
