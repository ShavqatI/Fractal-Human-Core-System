package com.fractal.domain.insurance.provider.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.insurance.provider.address.mapper.InsuranceProviderAddressMapperService;
import com.fractal.domain.insurance.provider.contact.mapper.InsuranceProviderContactMapperService;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderCompactResponse;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderRequest;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InsuranceProviderMapperServiceImpl implements InsuranceProviderMapperService {

    private final StatusService statusService;
    private final InsuranceProviderAddressMapperService addressMapperService;
    private final InsuranceProviderContactMapperService contactMapperService;


    @Override
    public InsuranceProviderResponse toDTO(InsuranceProvider insuranceProvider) {
        return new InsuranceProviderResponse(
                insuranceProvider.getId(),
                insuranceProvider.getName(),
                insuranceProvider.getFullName(),
                insuranceProvider.getTinNumber(),
                statusService.toCompactDTO(insuranceProvider.getStatus()),
                Optional.ofNullable(insuranceProvider.getContacts())
                        .orElse(emptyList())
                        .stream()
                        .map(contactMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(insuranceProvider.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressMapperService::toDTO)
                        .collect(Collectors.toList()),
                insuranceProvider.getCreatedDate()

        );
    }

    @Override
    public InsuranceProviderCompactResponse toCompactDTO(InsuranceProvider insuranceProvider) {
        return new InsuranceProviderCompactResponse(
                insuranceProvider.getId(),
                insuranceProvider.getName(),
                insuranceProvider.getFullName(),
                insuranceProvider.getTinNumber()
        );
    }

    @Override
    public InsuranceProvider toEntity(InsuranceProviderRequest dto) {
        return mapToEntity(new InsuranceProvider(), dto);
    }

    @Override
    public InsuranceProvider toEntity(InsuranceProvider insuranceProvider, InsuranceProviderRequest dto) {
        return mapToEntity(insuranceProvider, dto);
    }

    private InsuranceProvider mapToEntity(InsuranceProvider insuranceProvider, InsuranceProviderRequest dto) {
        insuranceProvider.setName(dto.name());
        insuranceProvider.setFullName(dto.fullName());
        insuranceProvider.setTinNumber(dto.tinNumber());
        insuranceProvider.setStatus(statusService.getById(dto.statusId()));
        dto.addresses().forEach(address -> insuranceProvider.addAddress(addressMapperService.toEntity(address)));
        dto.contacts().forEach(contact -> insuranceProvider.addContact(contactMapperService.toEntity(contact)));
        return insuranceProvider;
    }
}
