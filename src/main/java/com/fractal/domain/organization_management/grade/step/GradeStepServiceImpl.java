package com.fractal.domain.organization_management.grade.step;

import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepRequest;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepResponse;
import com.fractal.domain.organization_management.grade.step.mapper.GradeStepMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeStepServiceImpl implements GradeStepService {

    private final GradeStepRepository gradeStepRepository;
    private final GradeService gradeService;
    private final GradeStepMapperService mapperService;


    @Override
    @Transactional
    public GradeStep create(Long gradeId, GradeStepRequest dto) {
        var grade = gradeService.getById(gradeId);
        var step = mapperService.toEntity(dto);
        grade.addStep(step);
        gradeService.save(grade);
        return step;
    }



    @Override
    public List<GradeStep> getAllByGradeId(Long gradeId) {
        return gradeStepRepository.findAllByGradeId(gradeId);
    }

    @Override
    public GradeStep getById(Long gradeId, Long id) {
        return gradeStepRepository.findByGradeIdAndId(gradeId,id).orElseThrow(()-> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public GradeStep update(Long gradeId, Long id, GradeStepRequest dto) {
        var grade = gradeService.getById(gradeId);
        var step = grade.getSteps()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
        step = gradeStepRepository.save(mapperService.toEntity(step,dto));
        gradeService.save(grade);
        return step;
    }

    @Override
    public void delete(Long gradeId, Long id) {
        var grade = gradeService.getById(gradeId);
        var step = grade.getSteps()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
        grade.removeStep(step);
        gradeService.save(grade);
    }

    @Override
    public GradeStepResponse toDTO(GradeStep step) {
        return mapperService.toDTO(step);
    }
}
