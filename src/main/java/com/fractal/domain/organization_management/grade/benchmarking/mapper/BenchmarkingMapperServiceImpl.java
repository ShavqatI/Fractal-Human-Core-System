package com.fractal.domain.organization_management.grade.benchmarking.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.grade.benchmarking.Benchmarking;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingRequest;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingResponse;
import com.fractal.domain.organization_management.grade.benchmarking.type.BenchmarkingTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BenchmarkingMapperServiceImpl implements BenchmarkingMapperService {


    private final StatusService statusService;
    private final BenchmarkingTypeService benchmarkingTypeService;


    @Override
    public BenchmarkingResponse toDTO(Benchmarking benchmarking) {
        return new BenchmarkingResponse(
                benchmarking.getId(),
                benchmarkingTypeService.toDTO(benchmarking.getBenchmarkingType()),
                benchmarking.getMinSalary(),
                benchmarking.getAverageSalary(),
                benchmarking.getMaxSalary(),
                statusService.toCompactDTO(benchmarking.getStatus()),
                benchmarking.getCreatedDate()

        );
    }

    @Override
    public Benchmarking toEntity(BenchmarkingRequest dto) {
        return mapToEntity(new Benchmarking(),dto);
    }

    @Override
    public Benchmarking toEntity(Benchmarking benchmarking, BenchmarkingRequest dto) {
       return mapToEntity(benchmarking,dto);
    }

    private Benchmarking mapToEntity(Benchmarking benchmarking, BenchmarkingRequest dto) {
        benchmarking.setBenchmarkingType(benchmarkingTypeService.getById(dto.benchmarkingTypeId()));
        benchmarking.setMinSalary(dto.minSalary());
        benchmarking.setAverageSalary(dto.averageSalary());
        benchmarking.setMaxSalary(dto.maxSalary());
        benchmarking.setStatus(statusService.getById(dto.statusId()));
        return benchmarking;
    }

}
