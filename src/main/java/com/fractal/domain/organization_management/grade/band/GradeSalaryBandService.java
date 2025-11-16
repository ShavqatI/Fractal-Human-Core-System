package com.fractal.domain.organization_management.grade.band;

import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandRequest;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandResponse;

import java.util.List;

public interface GradeSalaryBandService {

    GradeSalaryBand create(Long organizationId, GradeSalaryBandRequest dto);

    GradeSalaryBand getById(Long organizationId, Long id);

    List<GradeSalaryBand> getAllByGradeId(Long gradeId);

    GradeSalaryBand update(Long gradeId, Long id, GradeSalaryBandRequest dto);

    void delete(Long organizationId, Long id);

    GradeSalaryBandResponse toDTO(GradeSalaryBand step);
}
