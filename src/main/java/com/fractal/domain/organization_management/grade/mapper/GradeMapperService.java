package com.fractal.domain.organization_management.grade.mapper;

import com.fractal.domain.employee_management.employment.EmploymentHistory;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import com.fractal.domain.organization_management.grade.Grade;
import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;

public interface GradeMapperService {
    GradeResponse toDTO(Grade grade);
    Grade toEntity(GradeRequest dto);
    Grade toEntity(Grade grade, GradeRequest dto);
}


