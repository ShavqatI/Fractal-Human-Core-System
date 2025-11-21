package com.fractal.domain.dictionary.calendar.holiday.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record HolidayCalenderResponse(
        Long id,
        String code,
        String name,
        LocalDate date,
        LocalDateTime createdDate

) {

}
