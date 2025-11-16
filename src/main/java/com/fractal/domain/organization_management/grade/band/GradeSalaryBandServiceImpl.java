package com.fractal.domain.organization_management.grade.band;

import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandRequest;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandResponse;
import com.fractal.domain.organization_management.grade.band.mapper.GradeSalaryBandMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeSalaryBandServiceImpl implements GradeSalaryBandService {

    private final GradeSalaryBandRepository gradeSalaryBandRepository;
    private final GradeService gradeService;
    private final GradeSalaryBandMapperService mapperService;


    @Override
    @Transactional
    public GradeSalaryBand create(Long gradeId, GradeSalaryBandRequest dto) {
        var grade = gradeService.getById(gradeId);
        var salaryBand = mapperService.toEntity(dto);
        grade.addSalaryBand(salaryBand);
        gradeService.save(grade);
        return salaryBand;
    }


    @Override
    public List<GradeSalaryBand> getAllByGradeId(Long gradeId) {
        return gradeSalaryBandRepository.findAllByGradeId(gradeId);
    }

    @Override
    public GradeSalaryBand getById(Long gradeId, Long id) {
        return gradeSalaryBandRepository.findByGradeIdAndId(gradeId, id).orElseThrow(() -> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public GradeSalaryBand update(Long gradeId, Long id, GradeSalaryBandRequest dto) {
        var grade = gradeService.getById(gradeId);
        var salaryBand = grade.getSalaryBands()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
        salaryBand = gradeSalaryBandRepository.save(mapperService.toEntity(salaryBand, dto));
        gradeService.save(grade);
        return salaryBand;
    }

    @Override
    public void delete(Long gradeId, Long id) {
        var grade = gradeService.getById(gradeId);
        var salaryBand = grade.getSalaryBands()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
        grade.removeSalaryBand(salaryBand);
        gradeService.save(grade);
    }

    @Override
    public GradeSalaryBandResponse toDTO(GradeSalaryBand step) {
        return mapperService.toDTO(step);
    }
}
