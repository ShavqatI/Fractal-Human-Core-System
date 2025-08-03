package com.fractal.domain.contact.dto;

import com.fractal.domain.contact.type.dto.ContactTypeResponse;

import java.time.LocalDateTime;

public record ContactResponse(
        Long id,
        ContactTypeResponse contactType,
        String value,
        LocalDateTime createdDate
) {
}
