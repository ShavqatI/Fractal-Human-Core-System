package com.fractal.domain.organization_management.grade.benchmarking;

import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingRequest;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingResponse;

import java.util.List;

public interface BenchmarkingService {

    Benchmarking create(Long organizationId, BenchmarkingRequest dto);
    Benchmarking getById(Long organizationId, Long id);
    List<Benchmarking> getAllByGradeId(Long gradeId);
    Benchmarking update(Long gradeId, Long id, BenchmarkingRequest dto);
    void delete(Long organizationId, Long id);
    BenchmarkingResponse toDTO(Benchmarking step);
}
