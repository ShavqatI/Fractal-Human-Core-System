package com.fractal.domain.employee_management.vacation.dto;

import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.vacation.category.VacationCategory;
import com.fractal.domain.employee_management.vacation.type.VacationType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.time.LocalDate;

public record VacationRequest(
    @NotNull
    Long employeeId,
    @NotNull
    Long successorEmployeeId,
    @NotNull
    Long vacationCategoryId,
    @NotNull
    Long vacationTypeId,
    Long statusId,
    LocalDate startDate,
    LocalDate endDate,
    Integer days,
    String orderNumber,
    LocalDate orderDate,
    String description

    )

{}