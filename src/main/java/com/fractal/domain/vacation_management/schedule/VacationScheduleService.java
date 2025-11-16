package com.fractal.domain.vacation_management.schedule;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

import java.util.List;

public interface VacationScheduleService extends ApprovalWorkflowAware<Long, VacationSchedule> {
    VacationSchedule create(VacationScheduleRequest dto);
    List<VacationSchedule> getAll();
    VacationSchedule getById(Long id);
    List<VacationSchedule>  getAllByEmployeeId(Long employeeId);
    VacationSchedule update(Long id, VacationScheduleRequest dto);
    void deleteById(Long id);
    VacationScheduleResponse toDTO(VacationSchedule schedule);
    VacationSchedule save(VacationSchedule schedule);
}
