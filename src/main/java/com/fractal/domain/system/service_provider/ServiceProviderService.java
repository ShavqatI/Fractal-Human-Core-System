package com.fractal.domain.system.service_provider;

import com.fractal.domain.system.service_provider.dto.ServiceProviderRequest;
import com.fractal.domain.system.service_provider.dto.ServiceProviderResponse;

import java.util.List;

public interface ServiceProviderService {

    ServiceProvider create(ServiceProviderRequest dto);

    List<ServiceProvider> getAll();

    ServiceProvider getByCode(String code);

    ServiceProvider getById(Long id);

    ServiceProvider update(Long id, ServiceProviderRequest dto);

    void deleteById(Long id);

    ServiceProviderResponse toDTO(ServiceProvider serviceProvider);
}
