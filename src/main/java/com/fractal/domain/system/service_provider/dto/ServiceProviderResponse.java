package com.fractal.domain.system.service_provider.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.localization.language.dto.LanguageResponse;
import com.fractal.domain.system.message.type.dto.MessageTypeResponse;
import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeRequest;
import com.fractal.domain.system.service_provider.type.dto.ServiceProviderTypeResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ServiceProviderResponse(
        Long id,
        ServiceProviderTypeResponse serviceProviderType,
        String code,
        String name,
        String host,
        Integer port,
        String protocol,
        String username,
        String password,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
