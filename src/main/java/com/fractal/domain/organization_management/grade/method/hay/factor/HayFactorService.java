package com.fractal.domain.organization_management.grade.method.hay.factor;

import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorResponse;

import java.util.List;

public interface HayFactorService {
    HayFactor create(HayFactorRequest dto);

    List<HayFactor> getAll();

    HayFactor getByCode(String code);

    HayFactor getById(Long id);

    HayFactor update(Long id, HayFactorRequest dto);

    void deleteById(Long id);

    HayFactorResponse toDTO(HayFactor factor);

    HayFactorCompactResponse toCompactDTO(HayFactor factor);
}
