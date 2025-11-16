package com.fractal.domain.organization_management.grade.method.hay.factor.type;

import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeResponse;

import java.util.List;

public interface HayFactorTypeService {

    HayFactorType create(HayFactorTypeRequest dto);

    List<HayFactorType> getAll();

    HayFactorType getByCode(String code);

    HayFactorType getById(Long id);

    HayFactorType update(Long id, HayFactorTypeRequest dto);

    void deleteById(Long id);

    HayFactorTypeResponse toDTO(HayFactorType hayFactorType);

    HayFactorTypeCompactResponse toCompactDTO(HayFactorType hayFactorType);

    HayFactorType addChild(Long id, HayFactorTypeRequest dto);

    HayFactorType updateChild(Long id, Long childId, HayFactorTypeRequest dto);

    HayFactorType deleteChild(Long id, Long childId);
}
