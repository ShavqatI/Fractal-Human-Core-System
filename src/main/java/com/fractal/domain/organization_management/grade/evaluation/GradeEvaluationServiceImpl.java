package com.fractal.domain.organization_management.grade.evaluation;

import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.grade.evaluation.mapper.GradeEvaluationMapperService;
import com.fractal.domain.organization_management.grade.method.GradingEvaluation;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;
import com.fractal.domain.organization_management.grade.method.hay.HayEvaluationService;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationRequest;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeEvaluationServiceImpl implements GradeEvaluationService {

    private final GradeEvaluationRepository gradeEvaluationRepository;
    private final GradeService gradeService;
    private final HayEvaluationService hayEvaluationService;
    private final GradeEvaluationMapperService gradeEvaluationMapperService;

    @Override
    @Transactional
    public GradeEvaluation create(Long gradeId, GradingEvaluationRequest dto) {
        GradingEvaluation evaluation = null;
        if (dto instanceof HayEvaluationRequest) {
            evaluation = hayEvaluationService.create((HayEvaluationRequest) dto);
        }
        var gradeEvaluation = GradeEvaluation.builder().evaluation(evaluation).build();
        var grade = gradeService.getById(gradeId);
        grade.addEvaluation(gradeEvaluation);
        gradeService.save(grade);
        return gradeEvaluation;
    }

    @Override
    public GradeEvaluation getById(Long gradeId, Long id) {
        return gradeEvaluationRepository.findByGradeIdAndId(gradeId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public List<GradeEvaluation> getAllByGradeId(Long gradeId) {
        return gradeEvaluationRepository.findAllByGradeId(gradeId);
    }


    @Override
    public GradeEvaluation update(Long gradeId, Long id, GradingEvaluationRequest dto) {
        var grade = gradeService.getById(gradeId);
        var gradeEvaluation = grade.getEvaluations()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        if (dto instanceof HayEvaluationRequest) {
            hayEvaluationService.update(gradeEvaluation.getEvaluation().getId(),(HayEvaluationRequest) dto);
        }
        gradeEvaluationRepository.save(gradeEvaluation);
        gradeService.save(grade);
        return gradeEvaluation;
    }


    @Override
    @Transactional
    public void delete(Long gradeId, Long id) {
        var grade = gradeService.getById(gradeId);
        var gradeEvaluation = grade.getEvaluations()
                .stream()
                .filter(eh-> eh.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        grade.removeEvaluation(gradeEvaluation);
        gradeService.save(grade);
    }

    @Override
    public GradingEvaluationResponse toDTO(GradeEvaluation evaluation) {
        return gradeEvaluationMapperService.toDTO(evaluation);
    }
}
