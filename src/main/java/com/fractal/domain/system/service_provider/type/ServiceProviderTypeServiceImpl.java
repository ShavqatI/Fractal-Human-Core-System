package com.fractal.domain.system.service_provider.type;

import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeRequest;
import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ServiceProviderTypeServiceImpl implements ServiceProviderTypeService {

    private final ServiceProviderTypeRepository serviceProviderTypeRepository;

    @Override
    public ServiceProviderType create(ServiceProviderTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ServiceProviderType> getAll() {
        return serviceProviderTypeRepository.findAll();
    }

    @Override
    public ServiceProviderType getByCode(String code) {
        return serviceProviderTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with code: " + code + " not found"));
    }

    @Override
    public ServiceProviderType getById(Long id) {
        return findById(id);
    }

    @Override
    public ServiceProviderType update(Long id, ServiceProviderTypeRequest dto) {
        try {
            ServiceProviderType serviceProviderType = findById(id);
            serviceProviderType.setCode(dto.code());
            serviceProviderType.setName(dto.name());
            serviceProviderType.setDescription(dto.description());
            return save(serviceProviderType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        serviceProviderTypeRepository.delete(findById(id));
    }

    @Override
    public ServiceProviderTypeResponse toDTO(ServiceProviderType serviceProviderType) {
        return new ServiceProviderTypeResponse(
                serviceProviderType.getId(),
                serviceProviderType.getCode(),
                serviceProviderType.getName(),
                serviceProviderType.getDescription(),
                serviceProviderType.getCreatedDate()
        );
    }

    private ServiceProviderType toEntity(ServiceProviderTypeRequest dto) {
        return ServiceProviderType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    private ServiceProviderType save(ServiceProviderType serviceProviderType) {
        try {
            return serviceProviderTypeRepository.save(serviceProviderType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ServiceProviderType findById(Long id) {
        return serviceProviderTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with id: " + id + " not found"));
    }

}
