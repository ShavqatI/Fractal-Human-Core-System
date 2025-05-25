package com.fractal.domain.employee_management.attendance.absence.type;

import com.fractal.domain.employee_management.attendance.absence.type.dto.AbsenceTypeRequest;
import com.fractal.domain.employee_management.attendance.absence.type.dto.AbsenceTypeResponse;
import com.fractal.domain.employee_management.education.type.EducationType;
import com.fractal.domain.employee_management.education.type.dto.EducationTypeRequest;
import com.fractal.domain.employee_management.education.type.dto.EducationTypeResponse;

import java.util.List;

public interface AbsenceTypeService {

    AbsenceType create(AbsenceTypeRequest dto);
    List<AbsenceType> getAll();
    AbsenceType getByCode(String code);
    AbsenceType getById(Long id);
    AbsenceType update(Long id, AbsenceTypeRequest dto);
    void deleteById(Long id);
    AbsenceTypeResponse toDTO(AbsenceType absenceType);
}
