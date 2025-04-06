package com.fractal.domain.location.address.type.dto;
import jakarta.validation.constraints.*;
public record AddressTypeDTO(
        Long id,
        @NotBlank
        @Pattern(regexp = "^[A-Z]{3,20}$", message = "Code must be in Latin uppercase letters")
        String code,
        @NotBlank
        @Size(min = 3,max = 100,message = "The code length should be in (3 to 20 symbols)")
        @Pattern(regexp = "^\\p{L}[\\p{L}\\p{M}\\p{S}\\p{P}\\p{N}\\s]*$",message = "Only Unicode letters, symbols, punctuation, numbers and spaces are allowed")
        String name

) {

}
