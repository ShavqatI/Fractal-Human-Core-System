package com.fractal.domain.order.punishment.dto;

import com.fractal.domain.employment.punishment.dto.PunishmentRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record PunishmentOrderRequest(
        Long orderTypeId,
        Long employeeId,
        PunishmentRequest punishment,
        String number,
        LocalDate date,
        String sourceDocument,
        List<MultipartFile> files
) {
}
