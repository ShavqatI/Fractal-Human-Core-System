package com.fractal.domain.localization.layout_label.dto;

import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record LayoutLabelRequest(
        @NotBlank
        @Size(min = 3,max = 200,message = "The name length should be in (3 to 200 symbols)")
        @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
        String name,

        List<LayoutLabelDetailRequest> details
) {}
