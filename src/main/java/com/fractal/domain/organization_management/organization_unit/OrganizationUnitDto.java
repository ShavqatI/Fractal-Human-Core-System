package com.fractal.domain.organization_management.organization_unit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record OrganizationUnitDto(
    Long id,
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3,20}$", message = "Code must be in Latin uppercase letters")
    String code,
    @NotBlank
    @Size(min = 3,max = 100,message = "The code length should be in (3 to 20 symbols)")
    @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
    String name,

    @NotBlank
    @Size(min = 3,max = 500,message = "The description length should be in (3 to 500 symbols)")
    String description,
    LocalDateTime createdDate
 )
{}
