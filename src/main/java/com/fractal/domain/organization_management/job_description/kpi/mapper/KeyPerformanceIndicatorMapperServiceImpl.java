package com.fractal.domain.organization_management.job_description.kpi.mapper;

import com.fractal.domain.organization_management.job_description.kpi.KeyPerformanceIndicator;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorRequest;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class KeyPerformanceIndicatorMapperServiceImpl implements KeyPerformanceIndicatorMapperService {

    @Override
    public KeyPerformanceIndicatorResponse toDTO(KeyPerformanceIndicator keyPerformanceIndicator) {
        return new KeyPerformanceIndicatorResponse(
                keyPerformanceIndicator.getId(),
                keyPerformanceIndicator.getName(),
                keyPerformanceIndicator.getDescription(),
                keyPerformanceIndicator.getMeasureUnit(),
                keyPerformanceIndicator.getTargetValue(),
                keyPerformanceIndicator.getFrequency(),
                keyPerformanceIndicator.getCreatedDate()
        );
    }

    @Override
    public KeyPerformanceIndicator toEntity(KeyPerformanceIndicatorRequest dto) {
        return mapToEntity(new KeyPerformanceIndicator(), dto);
    }

    @Override
    public KeyPerformanceIndicator toEntity(KeyPerformanceIndicator keyPerformanceIndicator, KeyPerformanceIndicatorRequest dto) {
        return mapToEntity(keyPerformanceIndicator, dto);
    }

    private KeyPerformanceIndicator mapToEntity(KeyPerformanceIndicator keyPerformanceIndicator, KeyPerformanceIndicatorRequest dto) {
        keyPerformanceIndicator.setName(dto.name());
        keyPerformanceIndicator.setDescription(dto.description());
        keyPerformanceIndicator.setMeasureUnit(dto.measureUnit());
        keyPerformanceIndicator.setTargetValue(dto.targetValue());
        keyPerformanceIndicator.setFrequency(dto.frequency());

        return keyPerformanceIndicator;
    }
}
