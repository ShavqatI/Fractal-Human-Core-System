package com.fractal.domain.employment.internal.order.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record InternalEmploymentOrderRequest(
        Long orderTypeId,
        List<MultipartFile> files

) {
}
