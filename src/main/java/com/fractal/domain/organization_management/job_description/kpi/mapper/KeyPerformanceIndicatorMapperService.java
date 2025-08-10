package com.fractal.domain.organization_management.job_description.kpi.mapper;

import com.fractal.domain.organization_management.job_description.kpi.KeyPerformanceIndicator;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorRequest;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorResponse;

public interface KeyPerformanceIndicatorMapperService {
    KeyPerformanceIndicatorResponse toDTO(KeyPerformanceIndicator keyPerformanceIndicator);
    KeyPerformanceIndicator toEntity(KeyPerformanceIndicatorRequest dto);
    KeyPerformanceIndicator toEntity(KeyPerformanceIndicator keyPerformanceIndicator, KeyPerformanceIndicatorRequest dto);
}


