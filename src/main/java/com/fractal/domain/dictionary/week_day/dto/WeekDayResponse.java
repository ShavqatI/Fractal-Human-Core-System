package com.fractal.domain.dictionary.week_day.dto;

import java.time.LocalDateTime;

public record WeekDayResponse(
        Long id,
        String code,
        String name,

        Long index,
        LocalDateTime createdDate

) {

}
