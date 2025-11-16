package com.fractal.domain.insurance.type;

import com.fractal.domain.insurance.type.dto.InsuranceTypeRequest;
import com.fractal.domain.insurance.type.dto.InsuranceTypeResponse;

import java.util.List;

public interface InsuranceTypeService {

    InsuranceType create(InsuranceTypeRequest dto);

    List<InsuranceType> getAll();

    InsuranceType getByCode(String code);

    InsuranceType getById(Long id);

    InsuranceType update(Long id, InsuranceTypeRequest dto);

    void deleteById(Long id);

    InsuranceTypeResponse toDTO(InsuranceType insuranceType);
}
