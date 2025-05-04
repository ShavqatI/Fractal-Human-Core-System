package com.fractal.domain.organization_management.unit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OrganizationUnitCreate(

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3,20}$", message = "Code must be in Latin uppercase letters")
    String code,
    @NotNull
    @NotBlank
    @Size(min = 3,max = 100,message = "The code length should be in (3 to 20 symbols)")
    @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
    String name,

    @NotNull
    @NotBlank
    @Size(min = 3,max = 500,message = "The description length should be in (3 to 500 symbols)")
    String description
  )
{}
