package com.fractal.domain.order.state;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;


public record OrderStateResponse(
        Long id,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}
