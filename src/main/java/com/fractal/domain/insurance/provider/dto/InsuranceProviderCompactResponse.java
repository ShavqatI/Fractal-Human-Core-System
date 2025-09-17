package com.fractal.domain.insurance.provider.dto;

public record InsuranceProviderCompactResponse(
        Long id,
        String name,
        String fullName,
        String tinNumber
) {
}
