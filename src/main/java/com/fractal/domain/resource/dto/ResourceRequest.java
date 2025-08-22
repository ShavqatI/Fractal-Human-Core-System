package com.fractal.domain.resource.dto;

public record ResourceRequest(
        String url,
        String fileName,
        String contentType,
        Long sizeInBytes
) { }
