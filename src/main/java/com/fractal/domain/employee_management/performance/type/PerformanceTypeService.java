package com.fractal.domain.employee_management.performance.type;

import com.fractal.domain.employee_management.performance.type.dto.PerformanceTypeRequest;
import com.fractal.domain.employee_management.performance.type.dto.PerformanceTypeResponse;

import java.util.List;

public interface PerformanceTypeService {

    PerformanceType create(PerformanceTypeRequest dto);
    List<PerformanceType> getAll();
    PerformanceType getByCode(String code);
    PerformanceType getById(Long id);
    PerformanceType update(Long id, PerformanceTypeRequest dto);
    void deleteById(Long id);
    PerformanceTypeResponse toDTO(PerformanceType performanceType);
}
