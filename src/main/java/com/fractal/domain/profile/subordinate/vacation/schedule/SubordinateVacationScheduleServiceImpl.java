package com.fractal.domain.profile.subordinate.vacation.schedule;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.VacationScheduleService;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleCancelRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class SubordinateVacationScheduleServiceImpl implements SubordinateVacationScheduleService {

    private final VacationScheduleService vacationScheduleService;
    private final AuthenticatedService authenticatedService;
    private final SubordinateService subordinateService;


    @Override
    public VacationSchedule create(SubordinateVacationScheduleRequest dto) {
        return vacationScheduleService.create(mapDTO(dto));
    }

    @Override
    public VacationSchedule getById(Long id) {
        return findById(id);
    }

    @Override
    public List<VacationSchedule> getAll() {
        var subordinates = subordinateService.getActiveEmployees(authenticatedService.getEmployeeId());
        List<VacationSchedule> vacationSchedules = new ArrayList<>();
        subordinates.forEach(employee -> vacationSchedules.addAll(
                vacationScheduleService.getAllByEmployeeId(employee.getId())
                        .stream()
                        .sorted(Comparator.comparing(VacationSchedule::getId).reversed())
                        .collect(Collectors.toList())
        ));
        return vacationSchedules;
     }
    @Override
    public VacationSchedule update(Long id, SubordinateVacationScheduleRequest dto) {
        return vacationScheduleService.update(findById(id).getId(),mapDTO(dto));
    }

    @Override
    public void deleteById(Long id) {
        vacationScheduleService.deleteById(findById(id).getId());
    }

    public VacationScheduleResponse toDTO(VacationSchedule schedule) {
        return vacationScheduleService.toDTO(schedule);
    }

    @Override
    public VacationSchedule review(Long id) {
        return vacationScheduleService.review(findById(id).getId());
    }

    @Override
    public VacationSchedule approve(Long id) {
        return vacationScheduleService.approve(findById(id).getId());
    }
    @Override
    public VacationSchedule cancel(VacationScheduleCancelRequest dto) {
        return vacationScheduleService.cancel(new VacationScheduleCancelRequest(findById(dto.id()).getId(), dto.reason()));
    }
    private VacationSchedule findById(Long id){
        try {
            var schedule = vacationScheduleService.getById(id);
            var subordinate = subordinateService.getActiveEmployee(authenticatedService.getEmployeeId(),schedule.getEmployee().getId());
            if(subordinate != null) return schedule;
            else return null;
        }
        catch (ResourceNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private VacationScheduleRequest mapDTO(SubordinateVacationScheduleRequest dto) {
       return new VacationScheduleRequest(
               dto.employeeId(),
               dto.startDate(),
               dto.startDate().plusDays(dto.days() - 1)
       );
    }


}
