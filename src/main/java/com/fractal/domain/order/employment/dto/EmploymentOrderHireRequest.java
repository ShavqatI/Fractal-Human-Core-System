package com.fractal.domain.order.employment.dto;

import com.fractal.domain.employee_management.employment.usecase.hire.dto.HireRequest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record EmploymentOrderHireRequest(
        Long orderTypeId,
        String number,
        LocalDate date,
        String sourceDocument,
        Long employeeId,
        HireRequest hire,
        List<MultipartFile> files

) {
}
