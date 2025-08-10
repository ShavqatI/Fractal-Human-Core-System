package com.fractal.domain.organization_management.job_description.kpi;

import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorRequest;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorResponse;

import java.util.List;

public interface KeyPerformanceIndicatorService {

    KeyPerformanceIndicator create(Long jobDescriptionId, KeyPerformanceIndicatorRequest dto);
    List<KeyPerformanceIndicator> getAllByJobDescriptionId(Long jobDescriptionId);
    KeyPerformanceIndicator getById(Long jobDescriptionId ,Long id);
    KeyPerformanceIndicator update(Long jobDescriptionId,Long id, KeyPerformanceIndicatorRequest dto);
    void delete(Long jobDescriptionId, Long id);
    KeyPerformanceIndicatorResponse toDTO(KeyPerformanceIndicator keyPerformanceIndicator);
}
