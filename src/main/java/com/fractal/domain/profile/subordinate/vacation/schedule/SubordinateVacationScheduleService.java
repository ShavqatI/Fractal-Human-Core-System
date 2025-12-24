package com.fractal.domain.profile.subordinate.vacation.schedule;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.profile.subordinate.vacation.request.SubordinateVacationRequestRequest;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleCancelRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;

import java.util.List;

public interface SubordinateVacationScheduleService extends ApprovalWorkflowAware<Long,VacationSchedule>, Cancelable<VacationScheduleCancelRequest,VacationSchedule> {
    VacationSchedule create(SubordinateVacationScheduleRequest dto);
    VacationSchedule getById(Long id);
    List<VacationSchedule> getAll();
    VacationSchedule update(Long id, SubordinateVacationScheduleRequest dto);
    void deleteById(Long id);
    VacationScheduleResponse toDTO(VacationSchedule schedule);


}
