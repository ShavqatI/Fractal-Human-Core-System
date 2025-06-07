package com.fractal.domain.employee_management.education.grade_point_average.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record GradePointAverageRequest(
         @NotBlank
         @NotNull
         @Pattern(regexp = "^[A-Z]{1}$", message = "Value must be in Latin uppercase letters")
         String value,
         @NotNull
         Double scale
) {
}
