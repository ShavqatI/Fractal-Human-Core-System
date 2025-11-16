package com.fractal.domain.work_schedule.dto;

import java.time.LocalTime;

public record WorkScheduleRequest(
        Long weekDayId,
        LocalTime startTime,
        LocalTime endTime,
        Long statusId
) {
}
