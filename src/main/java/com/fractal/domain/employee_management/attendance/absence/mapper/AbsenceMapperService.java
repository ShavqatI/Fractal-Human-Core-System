package com.fractal.domain.employee_management.attendance.absence.mapper;

import com.fractal.domain.employee_management.attendance.absence.Absence;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCompactRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceResponse;

public interface AbsenceMapperService {
    AbsenceResponse toDTO(Absence absence);

    Absence toEntity(AbsenceRequest dto);
    Absence toEntity(AbsenceCompactRequest dto);

    Absence toEntity(Absence absence, AbsenceRequest dto);
}


