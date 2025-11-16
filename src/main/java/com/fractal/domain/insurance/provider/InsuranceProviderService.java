package com.fractal.domain.insurance.provider;

import com.fractal.domain.insurance.provider.dto.InsuranceProviderCompactResponse;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderRequest;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderResponse;

import java.util.List;

public interface InsuranceProviderService {
    InsuranceProvider create(InsuranceProviderRequest dto);

    List<InsuranceProvider> getAll();

    InsuranceProvider getById(Long id);

    InsuranceProvider update(Long id, InsuranceProviderRequest dto);

    void deleteById(Long id);

    InsuranceProviderResponse toDTO(InsuranceProvider insuranceProvider);

    InsuranceProviderCompactResponse toCompactDTO(InsuranceProvider insuranceProvider);

    InsuranceProvider save(InsuranceProvider insuranceProvider);


}
