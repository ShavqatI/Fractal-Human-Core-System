package com.fractal.domain.resource.dto;

import java.time.LocalDateTime;

public record ResourceResponse(
        Long id,
        String url,
        String fileName,
        String contentType,
        Long sizeInBytes,
        LocalDateTime createdDate
) {
}
