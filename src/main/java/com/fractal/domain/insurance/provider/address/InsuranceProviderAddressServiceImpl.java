package com.fractal.domain.insurance.provider.address;

import com.fractal.domain.insurance.provider.InsuranceProviderService;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressRequest;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressResponse;
import com.fractal.domain.insurance.provider.address.mapper.InsuranceProviderAddressMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceProviderAddressServiceImpl implements InsuranceProviderAddressService {

    private final InsuranceProviderAddressRepository insuranceProviderAddressRepository;
    private final InsuranceProviderAddressMapperService addressMapperService;
    private final InsuranceProviderService insuranceProviderService;


    @Override
    @Transactional
    public InsuranceProviderAddress create(Long insuranceProviderId, InsuranceProviderAddressRequest dto) {
        var insuranceProvider = insuranceProviderService.getById(insuranceProviderId);
        var address = addressMapperService.toEntity(dto);
        insuranceProvider.addAddress(address);
        insuranceProviderService.save(insuranceProvider);
        return address;
    }


    @Override
    public List<InsuranceProviderAddress> getAllByInsuranceProviderId(Long insuranceProviderId) {
        return insuranceProviderAddressRepository.findAllByInsuranceProviderId(insuranceProviderId);
    }

    @Override
    public InsuranceProviderAddress getById(Long insuranceProviderId, Long id) {
        return insuranceProviderAddressRepository.findByInsuranceProviderIdAndId(insuranceProviderId, id).orElseThrow(() -> new ResourceNotFoundException("Candidate address with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public InsuranceProviderAddress update(Long insuranceProviderId, Long id, InsuranceProviderAddressRequest dto) {
        var insuranceProvider = insuranceProviderService.getById(insuranceProviderId);
        var address = insuranceProvider.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate address with id: " + id + " not found"));
        address = insuranceProviderAddressRepository.save(addressMapperService.toEntity(address, dto));
        insuranceProviderService.save(insuranceProvider);
        return address;
    }

    @Override
    public void delete(Long insuranceProviderId, Long id) {
        var insuranceProvider = insuranceProviderService.getById(insuranceProviderId);
        var address = insuranceProvider.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate address with id: " + id + " not found"));
        insuranceProvider.removeAddress(address);
        insuranceProviderService.save(insuranceProvider);
    }

    @Override
    public InsuranceProviderAddressResponse toDTO(InsuranceProviderAddress address) {
        return addressMapperService.toDTO(address);
    }
}
