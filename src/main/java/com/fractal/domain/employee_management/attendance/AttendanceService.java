package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendancePeriodReportRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;

import java.nio.file.Path;
import java.util.List;

public interface AttendanceService extends ApprovalWorkflowAware<Long,Attendance> {
    Attendance create(AttendanceRequest dto);
    List<Attendance> create(List<AttendanceBatchRequest> dto);
    List<Attendance> review(List<Long> dto);
    List<Attendance> approve(List<Long> dto);
    List<Attendance> getAll();
    Attendance getById(Long id);
    List<Attendance> getAllByEmployeeId(Long employeeId);

    List<Attendance> getAllByUserId();

    List<Attendance> getAllByUserIdCreated();

    List<Attendance> getAllByUserIdReviewed();

    List<Attendance> getAllByUserIdApproved();

    Attendance update(Long id, AttendanceRequest dto);
    void deleteById(Long id);
    AttendanceResponse toDTO(Attendance attendance);
    Path periodReport(AttendancePeriodReportRequest dto);
}
