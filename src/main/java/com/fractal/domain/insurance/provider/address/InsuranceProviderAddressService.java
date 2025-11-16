package com.fractal.domain.insurance.provider.address;

import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressRequest;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressResponse;

import java.util.List;

public interface InsuranceProviderAddressService {

    InsuranceProviderAddress create(Long insuranceProviderId, InsuranceProviderAddressRequest dto);

    InsuranceProviderAddress getById(Long insuranceProviderId, Long id);

    List<InsuranceProviderAddress> getAllByInsuranceProviderId(Long insuranceProviderId);

    InsuranceProviderAddress update(Long insuranceProviderId, Long id, InsuranceProviderAddressRequest dto);

    void delete(Long insuranceProviderId, Long id);

    InsuranceProviderAddressResponse toDTO(InsuranceProviderAddress address);
}
