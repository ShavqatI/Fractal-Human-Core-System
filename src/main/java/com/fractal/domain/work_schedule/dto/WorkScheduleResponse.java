package com.fractal.domain.work_schedule.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.dictionary.week_day.WeekDay;
import com.fractal.domain.dictionary.week_day.dto.WeekDayResponse;
import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.location.country.dto.CountryCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record WorkScheduleResponse(
        Long id,
        WeekDayResponse weekDay,
        LocalTime startTime,
        LocalTime endTime,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }