package com.fractal.domain.employee_management.business_trip.expense.type.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record BusinessTripExpenseTypeRequest(
    @NotBlank
    @NotNull
    @Pattern(regexp = "^[A-Z]{2,20}$", message = "Code must be in Latin uppercase letters")
    String code,
    @NotNull
    @NotBlank
    @Size(min = 3,max = 100,message = "The name length should be in (3 to 20 symbols)")
    @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
    String name,
    Long statusId,
    List<BusinessTripExpenseTypeRequest> children

) {}
