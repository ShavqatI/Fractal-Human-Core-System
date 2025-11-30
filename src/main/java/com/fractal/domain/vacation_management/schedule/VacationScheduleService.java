package com.fractal.domain.vacation_management.schedule;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleSelfRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

import java.util.List;

public interface VacationScheduleService extends ApprovalWorkflowAware<Long, VacationSchedule> {
    VacationSchedule create(VacationScheduleRequest dto);
    VacationSchedule create(VacationScheduleSelfRequest dto);

    List<VacationSchedule> getAll();

    VacationSchedule getById(Long id);

    List<VacationSchedule> getAllByEmployeeId();

    VacationSchedule update(Long id, VacationScheduleRequest dto);
    VacationSchedule update(Long id, VacationScheduleSelfRequest dto);

    void deleteById(Long id);

    VacationScheduleResponse toDTO(VacationSchedule schedule);

}
