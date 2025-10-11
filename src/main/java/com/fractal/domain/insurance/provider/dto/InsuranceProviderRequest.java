package com.fractal.domain.insurance.provider.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.insurance.provider.address.dto.InsuranceProviderAddressRequest;

import java.util.List;

public record InsuranceProviderRequest(
        String name,
        String fullName,
        String tinNumber,
        Long statusId,
        List<ContactRequest> contacts,
        List<InsuranceProviderAddressRequest> addresses
) {
}
