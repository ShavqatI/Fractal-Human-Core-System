package com.fractal.domain.order.employment.dto;

import com.fractal.domain.employee_management.employment.usecase.hire.dto.TransferRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record EmploymentOrderTransferRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        String sourceDocument,
        Long employeeId,
        TransferRequest transfer,
        List<MultipartFile> files

) {
}
