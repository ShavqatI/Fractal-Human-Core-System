package com.fractal.domain.organization_management.grade.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.finance.currency.CurrencyService;
import com.fractal.domain.organization_management.grade.Grade;
import com.fractal.domain.organization_management.grade.band.mapper.GradeSalaryBandMapperService;
import com.fractal.domain.organization_management.grade.benchmarking.mapper.BenchmarkingMapperService;
import com.fractal.domain.organization_management.grade.dto.GradeCompactResponse;
import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;
import com.fractal.domain.organization_management.grade.evaluation.mapper.GradeEvaluationMapperService;
import com.fractal.domain.organization_management.grade.level.GradeLevelService;
import com.fractal.domain.organization_management.grade.matrix.mapper.GradeMatrixMapperService;
import com.fractal.domain.organization_management.grade.step.mapper.GradeStepMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class GradeMapperServiceImpl implements GradeMapperService {

    private final CurrencyService currencyService;
    private final GradeLevelService levelService;
    private final StatusService statusService;
    private final GradeStepMapperService stepMapperService;
    private final BenchmarkingMapperService benchmarkingMapperService;
    private final GradeMatrixMapperService matrixMapperService;
    private final GradeSalaryBandMapperService salaryBandMapperService;
    private final GradeEvaluationMapperService evaluationMapperService;


    @Override
    public GradeResponse toDTO(Grade grade) {
        return new GradeResponse(
                grade.getId(),
                grade.getCode(),
                grade.getName(),
                currencyService.toCompactDTO(grade.getCurrency()),
                levelService.toDTO(grade.getLevel()),
                grade.getMinSalary(),
                grade.getMaxSalary(),
                grade.getStartDate(),
                grade.getEndDate(),
                statusService.toCompactDTO(grade.getStatus()),
                grade.getNotes(),
                Optional.ofNullable(grade.getSteps())
                        .orElse(emptyList())
                        .stream()
                        .map(stepMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(grade.getBenchmarkings())
                        .orElse(emptyList())
                        .stream()
                        .map(benchmarkingMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(grade.getMatrices())
                        .orElse(emptyList())
                        .stream()
                        .map(matrixMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(grade.getSalaryBands())
                        .orElse(emptyList())
                        .stream()
                        .map(salaryBandMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(grade.getEvaluations())
                        .orElse(emptyList())
                        .stream()
                        .map(evaluationMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(grade.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                grade.getCreatedDate(),
                grade.getUpdatedDate()
        );
    }

    @Override
    public GradeCompactResponse toCompactDTO(Grade grade) {
        return new GradeCompactResponse(
                grade.getId(),
                grade.getCode(),
                grade.getName()
        );
    }

    @Override
    public Grade toEntity(GradeRequest dto) {
        return mapToEntity(new Grade(), dto);
    }

    @Override
    public Grade toEntity(Grade grade, GradeRequest dto) {
        return mapToEntity(grade, dto);
    }

    private Grade mapToEntity(Grade grade, GradeRequest dto) {
        grade.setCode(dto.code());
        grade.setName(dto.name());
        grade.setCurrency(currencyService.getById(dto.currencyId()));
        grade.setLevel(levelService.getById(dto.levelId()));
        grade.setMinSalary(dto.minSalary());
        grade.setMaxSalary(dto.maxSalary());
        grade.setStartDate(dto.startDate());
        grade.setEndDate(dto.endDate());
        grade.setStatus(statusService.getById(dto.statusId()));
        grade.setNotes(dto.notes());
        dto.steps().forEach(step -> grade.addStep(stepMapperService.toEntity(step)));
        dto.benchmarking().forEach(benchmarking -> grade.addBenchmarking(benchmarkingMapperService.toEntity(benchmarking)));
        dto.matrices().forEach(matrix -> grade.addMatrix(matrixMapperService.toEntity(matrix)));
        dto.salaryBands().forEach(salaryBand -> grade.addSalaryBand(salaryBandMapperService.toEntity(salaryBand)));
        dto.evaluations().forEach(evaluation -> grade.addEvaluation(evaluationMapperService.toEntity(evaluation)));
        dto.children().forEach(child -> grade.addChild(toEntity(child)));
        return grade;
    }

}
