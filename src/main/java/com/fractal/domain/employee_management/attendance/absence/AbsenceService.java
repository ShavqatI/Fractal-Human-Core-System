package com.fractal.domain.employee_management.attendance.absence;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCancelRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCompactRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceResponse;

import java.util.List;

public interface AbsenceService extends ApprovalWorkflowAware<Long, Absence>, Cancelable<AbsenceCancelRequest,Absence> {
    Absence create(AbsenceRequest dto);
    Absence create(AbsenceCompactRequest dto);

    List<Absence> getAll();

    Absence getById(Long id);

    List<Absence> getAllByEmployeeId(Long employeeId);

    Absence update(Long id, AbsenceRequest dto);

    void deleteById(Long id);

    AbsenceResponse toDTO(Absence absence);
}
