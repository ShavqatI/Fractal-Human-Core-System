package com.fractal.domain.insurance.provider.address.mapper;

import com.fractal.domain.insurance.provider.address.InsuranceProviderAddress;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressRequest;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressResponse;

public interface InsuranceProviderAddressMapperService {
    InsuranceProviderAddressResponse toDTO(InsuranceProviderAddress address);
    InsuranceProviderAddress toEntity(InsuranceProviderAddressRequest dto);
    InsuranceProviderAddress toEntity(InsuranceProviderAddress address, InsuranceProviderAddressRequest dto);
}


