package com.fractal.domain.organization_management.grade.benchmarking.mapper;

import com.fractal.domain.organization_management.grade.benchmarking.Benchmarking;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingRequest;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingResponse;

public interface BenchmarkingMapperService {
    BenchmarkingResponse toDTO(Benchmarking benchmarking);
    Benchmarking toEntity(BenchmarkingRequest dto);
    Benchmarking toEntity(Benchmarking benchmarking, BenchmarkingRequest dto);
}


