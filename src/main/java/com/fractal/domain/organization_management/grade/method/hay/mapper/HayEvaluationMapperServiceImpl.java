package com.fractal.domain.organization_management.grade.method.hay.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.grade.method.hay.HayEvaluation;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.HayFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class HayEvaluationMapperServiceImpl implements HayEvaluationMapperService {

    private final HayFactorService factorService;
    private final StatusService statusService;
    @Override
    public HayEvaluationResponse toDTO(HayEvaluation hayEvaluation) {
        return new HayEvaluationResponse(
                hayEvaluation.getId(),
                factorService.toCompactDTO(hayEvaluation.getHayFactor()),
                hayEvaluation.getPoint(),
                statusService.toCompactDTO(hayEvaluation.getStatus()),
                hayEvaluation.getCreatedDate()
        );
    }
    @Override
    public HayEvaluation toEntity(HayEvaluationRequest dto) {
        return mapToEntity(new HayEvaluation(), dto);
    }

    @Override
    public HayEvaluation toEntity(HayEvaluation hayEvaluation, HayEvaluationRequest dto) {
        return mapToEntity(hayEvaluation, dto);
    }

    private HayEvaluation mapToEntity(HayEvaluation hayEvaluation, HayEvaluationRequest dto) {
        hayEvaluation.setHayFactor(factorService.getById(dto.hayFactorId()));
        hayEvaluation.setPoint(dto.point());
        hayEvaluation.setStatus(statusService.getById(dto.statusId()));
        return hayEvaluation;
    }
}
