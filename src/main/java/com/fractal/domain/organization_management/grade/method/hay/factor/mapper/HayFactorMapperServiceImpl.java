package com.fractal.domain.organization_management.grade.method.hay.factor.mapper;

import com.fractal.domain.dictionary.measurement_unit.MeasurementUnitService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.grade.method.hay.factor.HayFactor;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.HayFactorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class HayFactorMapperServiceImpl implements HayFactorMapperService {

    private final HayFactorTypeService factorTypeService;
    private final MeasurementUnitService measurementUnitService;
    private final StatusService statusService;

    @Override
    public HayFactorResponse toDTO(HayFactor factor) {
        return new HayFactorResponse(
                factor.getId(),
                factorTypeService.toCompactDTO(factor.getHayFactorType()),
                measurementUnitService.toDTO(factor.getMeasurementUnit()),
                factor.getCode(),
                factor.getName(),
                factor.getDescription(),
                factor.getMinPoint(),
                factor.getMaxPoint(),
                factor.getWeight(),
                statusService.toCompactDTO(factor.getStatus()),
                factor.getCreatedDate()

        );
    }

    @Override
    public HayFactorCompactResponse toCompactDTO(HayFactor factor) {
        return new HayFactorCompactResponse(
                factor.getId(),
                factor.getCode(),
                factor.getName()
        );
    }

    @Override
    public HayFactor toEntity(HayFactorRequest dto) {
        return mapToEntity(new HayFactor(),dto);
    }

    @Override
    public HayFactor toEntity(HayFactor factor, HayFactorRequest dto) {
        return mapToEntity(factor,dto);
    }

    private HayFactor mapToEntity(HayFactor factor, HayFactorRequest dto) {
        factor.setHayFactorType(factorTypeService.getById(dto.factorTypeId()));
        factor.setMeasurementUnit(measurementUnitService.getById(dto.measurementUnitId()));
        factor.setCode(dto.code());
        factor.setName(dto.name());
        factor.setDescription(dto.description());
        factor.setMinPoint(dto.minPoint());
        factor.setMaxPoint(dto.maxPoint());
        factor.setWeight(dto.weight());
        factor.setStatus(statusService.getById(dto.statusId()));
        return factor;
    }

}
