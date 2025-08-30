package com.fractal.domain.work_schedule.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.dictionary.week_day.WeekDayService;
import com.fractal.domain.work_schedule.WorkSchedule;
import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class WorkScheduleMapperServiceImpl implements WorkScheduleMapperService {

    private final WeekDayService weekDayService;
    private final StatusService statusService;

    @Override
    public WorkScheduleResponse toDTO(WorkSchedule workSchedule) {
        return new WorkScheduleResponse(
                workSchedule.getId(),
                weekDayService.toDTO(workSchedule.getWeekDay()),
                workSchedule.getStartTime(),
                workSchedule.getEndTime(),
                statusService.toCompactDTO(workSchedule.getStatus()),
                workSchedule.getCreatedDate()
        );
    }

    @Override
    public WorkSchedule toEntity(WorkScheduleRequest dto) {
        return mapToEntity(new WorkSchedule(),dto);
    }

    @Override
    public WorkSchedule toEntity(WorkSchedule workSchedule, WorkScheduleRequest dto) {
       return mapToEntity(workSchedule,dto);
    }

    private WorkSchedule mapToEntity(WorkSchedule workSchedule, WorkScheduleRequest dto) {
        workSchedule.setWeekDay(weekDayService.getById(dto.weekDayId()));
        workSchedule.setStartTime(dto.startTime());
        workSchedule.setEndTime(dto.endTime());
        workSchedule.setStatus(statusService.getById(dto.statusId()));
        return workSchedule;
    }

}
