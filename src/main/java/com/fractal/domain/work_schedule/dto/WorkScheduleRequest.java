package com.fractal.domain.work_schedule.dto;

import com.fractal.domain.dictionary.week_day.WeekDay;

import java.time.LocalTime;

public record WorkScheduleRequest(
        Long weekDayId,
        LocalTime startTime,
        LocalTime endTime,
        Long statusId
) { }
