package com.fractal.domain.dictionary.calendar.holiday.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record HolidayCalenderRequest(
        @NotBlank
        String code,
        @NotBlank
        @Size(min = 3, max = 100, message = "The name length should be in (3 to 20 symbols)")
        @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$", message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
        String name,
        @NotNull
        LocalDate date
        ) {

}
