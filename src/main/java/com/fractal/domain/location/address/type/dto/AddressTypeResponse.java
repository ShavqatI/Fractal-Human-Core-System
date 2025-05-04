package com.fractal.domain.location.address.type.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AddressTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
