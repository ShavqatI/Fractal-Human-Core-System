package com.fractal.domain.system.service_provider;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.system.service_provider.dto.ServiceProviderRequest;
import com.fractal.domain.system.service_provider.dto.ServiceProviderResponse;
import com.fractal.domain.system.service_provider.type.ServiceProviderTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceProviderTypeService serviceProviderTypeService;
    private final StatusService statusService;


    @Override
    public ServiceProvider create(ServiceProviderRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ServiceProvider> getAll() {
        return serviceProviderRepository.findAll();
    }

    @Override
    public ServiceProvider getByCode(String code) {
        return serviceProviderRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with code: " + code + " not found"));
    }

    @Override
    public ServiceProvider getById(Long id) {
        return findById(id);
    }

    @Override
    public ServiceProvider update(Long id, ServiceProviderRequest dto) {
        try {
            ServiceProvider serviceProvider = findById(id);
            serviceProvider.setServiceProviderType(serviceProviderTypeService.getById(dto.serviceProviderTypeId()));
            serviceProvider.setCode(dto.code());
            serviceProvider.setName(dto.name());
            serviceProvider.setHost(dto.host());
            serviceProvider.setPort(dto.port());
            serviceProvider.setProtocol(dto.protocol());
            serviceProvider.setUsername(dto.username());
            serviceProvider.setPassword(dto.password());
            serviceProvider.setStatus(statusService.getById(dto.statusId()));
            return save(serviceProvider);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        serviceProviderRepository.delete(findById(id));
    }

    @Override
    public ServiceProviderResponse toDTO(ServiceProvider serviceProvider) {
        return new ServiceProviderResponse(
                serviceProvider.getId(),
                serviceProviderTypeService.toDTO(serviceProvider.getServiceProviderType()),
                serviceProvider.getCode(),
                serviceProvider.getName(),
                serviceProvider.getHost(),
                serviceProvider.getPort(),
                serviceProvider.getProtocol(),
                serviceProvider.getUsername(),
                serviceProvider.getPassword(),
                statusService.toCompactDTO(serviceProvider.getStatus()),
                serviceProvider.getCreatedDate()
        );
    }

    private ServiceProvider toEntity(ServiceProviderRequest dto) {
        return ServiceProvider.builder()
                .serviceProviderType(serviceProviderTypeService.getById(dto.serviceProviderTypeId()))
                .code(dto.code())
                .name(dto.name())
                .host(dto.host())
                .port(dto.port())
                .protocol(dto.protocol())
                .username(dto.username())
                .password(dto.password())
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private ServiceProvider save(ServiceProvider serviceProvider) {
        try {
            return serviceProviderRepository.save(serviceProvider);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ServiceProvider findById(Long id) {
        return serviceProviderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with id: " + id + " not found"));
    }

}
