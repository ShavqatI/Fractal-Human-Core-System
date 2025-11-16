package com.fractal.domain.insurance.provider.mapper;

import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderCompactResponse;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderRequest;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderResponse;

public interface InsuranceProviderMapperService {
    InsuranceProviderResponse toDTO(InsuranceProvider insuranceProvider);

    InsuranceProviderCompactResponse toCompactDTO(InsuranceProvider insuranceProvider);

    InsuranceProvider toEntity(InsuranceProviderRequest dto);

    InsuranceProvider toEntity(InsuranceProvider insuranceProvider, InsuranceProviderRequest dto);
}


