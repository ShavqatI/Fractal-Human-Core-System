package com.fractal.domain.location.address.type.dto;

import java.time.LocalDateTime;

public record AddressTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
