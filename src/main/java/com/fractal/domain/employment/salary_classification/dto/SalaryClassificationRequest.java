package com.fractal.domain.employment.salary_classification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SalaryClassificationRequest(
        @NotBlank
        @NotNull
        @Pattern(regexp = "^[A-Z_0-9]{2,30}$", message = "Code must be in Latin uppercase letters")
        String code,
        @NotNull
        @NotBlank
        @Size(min = 3, max = 100, message = "The name length should be in (3 to 20 symbols)")
        @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$", message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
        String name,
        Long statusId,
        List<SalaryClassificationRequest> children

) {
}
