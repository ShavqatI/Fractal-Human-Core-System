package com.fractal.domain.contact.dto;

public record ContactRequest(
        Long contactTypeId,
        String value
) {
}
