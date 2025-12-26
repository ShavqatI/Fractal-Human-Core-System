package com.fractal.domain.vacation_management.schedule;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleCancelRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

import java.util.List;

public interface VacationScheduleService extends ApprovalWorkflowAware<Long, VacationSchedule>, Cancelable<VacationScheduleCancelRequest, VacationSchedule> {
    VacationSchedule create(VacationScheduleRequest dto);
    List<VacationSchedule> getAll();
    VacationSchedule getById(Long id);
    List<VacationSchedule> getAllByEmployeeId(Long employeeId);
    VacationSchedule update(Long id, VacationScheduleRequest dto);
    void deleteById(Long id);
    VacationScheduleResponse toDTO(VacationSchedule schedule);

}
