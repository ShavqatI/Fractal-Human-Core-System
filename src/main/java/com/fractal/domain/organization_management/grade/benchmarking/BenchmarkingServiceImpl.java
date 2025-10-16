package com.fractal.domain.organization_management.grade.benchmarking;

import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingRequest;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingResponse;
import com.fractal.domain.organization_management.grade.benchmarking.mapper.BenchmarkingMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenchmarkingServiceImpl implements BenchmarkingService {

    private final BenchmarkingRepository benchmarkingRepository;
    private final GradeService gradeService;
    private final BenchmarkingMapperService mapperService;


    @Override
    @Transactional
    public Benchmarking create(Long gradeId, BenchmarkingRequest dto) {
        var grade = gradeService.getById(gradeId);
        var benchmarking = mapperService.toEntity(dto);
        grade.addBenchmarking(benchmarking);
        gradeService.save(grade);
        return benchmarking;
    }



    @Override
    public List<Benchmarking> getAllByGradeId(Long gradeId) {
        return benchmarkingRepository.findAllByGradeId(gradeId);
    }

    @Override
    public Benchmarking getById(Long gradeId, Long id) {
        return benchmarkingRepository.findByGradeIdAndId(gradeId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public Benchmarking update(Long gradeId, Long id, BenchmarkingRequest dto) {
        var grade = gradeService.getById(gradeId);
        var benchmarking = grade.getBenchmarkings()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        benchmarking = benchmarkingRepository.save(mapperService.toEntity(benchmarking,dto));
        gradeService.save(grade);
        return benchmarking;
    }

    @Override
    public void delete(Long gradeId, Long id) {
        var grade = gradeService.getById(gradeId);
        var benchmarking = grade.getBenchmarkings()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        grade.removeBenchmarking(benchmarking);
        gradeService.save(grade);
    }

    @Override
    public BenchmarkingResponse toDTO(Benchmarking step) {
        return mapperService.toDTO(step);
    }
}
