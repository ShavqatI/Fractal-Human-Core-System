package com.fractal.domain.organization_management.department.dto;

import com.fractal.domain.organization_management.organization_unit.OrganizationUnitDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public record DepartmentResponseDto(
        Long id,
        @NotBlank
        @Pattern(regexp = "^[A-Z]{3,20}$", message = "Code must be in Latin uppercase letters")
        String code,
        @NotBlank
        @Size(min = 3,max = 100,message = "The name length should be in (3 to 20 symbols)")
        @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
        String name,
        @NotBlank
        int level,
        @NotBlank
        String levelMap,
        DepartmentResponseDto parent,
        List<DepartmentResponseDto> children,
        OrganizationUnitDto organizationUnit,
        LocalDateTime createdDate
) {}
