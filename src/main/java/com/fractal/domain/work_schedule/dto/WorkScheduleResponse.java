package com.fractal.domain.work_schedule.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.dictionary.week_day.dto.WeekDayResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record WorkScheduleResponse(
        Long id,
        WeekDayResponse weekDay,
        LocalTime startTime,
        LocalTime endTime,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}