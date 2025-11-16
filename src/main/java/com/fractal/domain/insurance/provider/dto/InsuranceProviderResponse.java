package com.fractal.domain.insurance.provider.dto;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressResponse;

import java.time.LocalDateTime;
import java.util.List;

public record InsuranceProviderResponse(
        Long id,
        String name,
        String fullName,
        String tinNumber,
        StatusCompactResponse status,
        List<ContactResponse> contacts,
        List<InsuranceProviderAddressResponse> addresses,
        LocalDateTime createdDate

) {
}
