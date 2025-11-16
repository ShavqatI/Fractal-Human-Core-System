package com.fractal.domain.insurance.provider;

import com.fractal.domain.insurance.provider.dto.InsuranceProviderCompactResponse;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderRequest;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderResponse;
import com.fractal.domain.insurance.provider.mapper.InsuranceProviderMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class InsuranceProviderServiceImpl implements InsuranceProviderService {

    private final InsuranceProviderRepository insuranceProviderRepository;
    private final InsuranceProviderMapperService mapperService;

    @Override
    @Transactional
    public InsuranceProvider create(InsuranceProviderRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InsuranceProvider> getAll() {
        return insuranceProviderRepository.findAll();
    }

    @Override
    public InsuranceProvider getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public InsuranceProvider update(Long id, InsuranceProviderRequest dto) {
        try {
            InsuranceProvider insuranceProvider = mapperService.toEntity(findById(id), dto);
            return save(insuranceProvider);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        insuranceProviderRepository.delete(findById(id));
    }

    @Override
    public InsuranceProviderResponse toDTO(InsuranceProvider insuranceProvider) {
        return mapperService.toDTO(insuranceProvider);
    }

    @Override
    public InsuranceProviderCompactResponse toCompactDTO(InsuranceProvider insuranceProvider) {
        return mapperService.toCompactDTO(insuranceProvider);
    }

    @Override
    @Transactional
    public InsuranceProvider save(InsuranceProvider insuranceProvider) {
        try {
            return insuranceProviderRepository.save(insuranceProvider);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InsuranceProvider findById(Long id) {
        return insuranceProviderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance Provider with id: " + id + " not found"));
    }
}
