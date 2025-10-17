package com.fractal.domain.organization_management.grade.band.mapper;

import com.fractal.domain.organization_management.grade.band.GradeSalaryBand;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandRequest;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandResponse;

public interface GradeSalaryBandMapperService {
    GradeSalaryBandResponse toDTO(GradeSalaryBand salaryBand);
    GradeSalaryBand toEntity(GradeSalaryBandRequest dto);
    GradeSalaryBand toEntity(GradeSalaryBand salaryBand, GradeSalaryBandRequest dto);

}


