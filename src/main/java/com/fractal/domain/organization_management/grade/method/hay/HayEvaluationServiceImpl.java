package com.fractal.domain.organization_management.grade.method.hay;

import com.fractal.domain.organization_management.grade.method.GradingEvaluation;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationResponse;
import com.fractal.domain.organization_management.grade.method.hay.mapper.HayEvaluationMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class HayEvaluationServiceImpl implements HayEvaluationService {

    private final HayEvaluationRepository hayEvaluationRepository;
    private final HayEvaluationMapperService mapperService;

    @Override
    @Transactional
    public HayEvaluation create(HayEvaluationRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<HayEvaluation> getAll() {
        return hayEvaluationRepository.findAll();
    }

    @Override
    public HayEvaluation getById(Long id) {
        return findById(id);
    }


    @Override
    @Transactional
    public GradingEvaluation save(GradingEvaluation gradingEvaluation) {
        return save((HayEvaluation) gradingEvaluation);
    }


    @Override
    @Transactional
    public HayEvaluation update(Long id, HayEvaluationRequest dto) {
        try {
            HayEvaluation hayEvaluation = mapperService.toEntity(findById(id),dto);
            return save(hayEvaluation);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      hayEvaluationRepository.delete(findById(id));
    }

    @Override
    public HayEvaluationResponse toDTO(HayEvaluation hayEvaluation) {
        return mapperService.toDTO(hayEvaluation);
    }

    @Override
    @Transactional
    public HayEvaluation save(HayEvaluation hayEvaluation) {
        try {
            return hayEvaluationRepository.save(hayEvaluation);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private HayEvaluation findById(Long id) {
        return hayEvaluationRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
