package com.fractal.domain.system.service_provider.type;

import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeRequest;
import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeResponse;

import java.util.List;

public interface ServiceProviderTypeService {

    ServiceProviderType create(ServiceProviderTypeRequest dto);

    List<ServiceProviderType> getAll();

    ServiceProviderType getByCode(String code);

    ServiceProviderType getById(Long id);

    ServiceProviderType update(Long id, ServiceProviderTypeRequest dto);

    void deleteById(Long id);

    ServiceProviderTypeResponse toDTO(ServiceProviderType serviceProviderType);
}
