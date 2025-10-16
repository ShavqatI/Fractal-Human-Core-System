package com.fractal.domain.organization_management.grade.benchmarking.type;

import com.fractal.domain.organization_management.grade.benchmarking.type.dto.BenchmarkingTypeRequest;
import com.fractal.domain.organization_management.grade.benchmarking.type.dto.BenchmarkingTypeResponse;

import java.util.List;

public interface BenchmarkingTypeService {

    BenchmarkingType create(BenchmarkingTypeRequest dto);
    List<BenchmarkingType> getAll();
    BenchmarkingType getByCode(String code);
    BenchmarkingType getById(Long id);
    BenchmarkingType update(Long id, BenchmarkingTypeRequest dto);
    void deleteById(Long id);
    BenchmarkingTypeResponse toDTO(BenchmarkingType benchmarkingType);
}
