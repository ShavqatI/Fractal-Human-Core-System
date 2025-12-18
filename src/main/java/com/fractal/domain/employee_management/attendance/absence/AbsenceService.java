package com.fractal.domain.employee_management.attendance.absence;

import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCompactRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceResponse;

import java.util.List;

public interface AbsenceService {
    Absence create(AbsenceRequest dto);
    Absence create(AbsenceCompactRequest dto);

    List<Absence> getAll();

    Absence getById(Long id);

    List<Absence> getAllByEmployeeId(Long employeeId);

    Absence update(Long id, AbsenceRequest dto);

    void deleteById(Long id);

    AbsenceResponse toDTO(Absence absence);
}
