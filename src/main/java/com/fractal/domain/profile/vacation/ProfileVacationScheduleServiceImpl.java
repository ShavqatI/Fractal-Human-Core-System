package com.fractal.domain.profile.vacation;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.VacationScheduleService;
import com.fractal.domain.profile.vacation.dto.ProfileVacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileVacationScheduleServiceImpl implements ProfileVacationScheduleService {

    private final VacationScheduleService vacationScheduleService;
    private final AuthenticatedService authenticatedService;

    @Override
    public VacationSchedule create(ProfileVacationScheduleRequest dto) {
        return vacationScheduleService.create(new VacationScheduleRequest(authenticatedService.getEmployeeId(), dto.startDate(),dto.startDate().plusDays(dto.days() - 1)));
    }
    @Override
    public VacationSchedule getById(Long id) {
        return findById(id);
    }

    @Override
    public List<VacationSchedule> getAll() {
        return vacationScheduleService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }
    @Override
    public VacationSchedule update(Long id, ProfileVacationScheduleRequest dto) {
        var schedule = findById(id);
        return vacationScheduleService.update(schedule.getId(),new VacationScheduleRequest(authenticatedService.getEmployeeId(), dto.startDate(),dto.startDate().plusDays(dto.days() - 1)));
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
        var schedule = findById(id);
        return vacationScheduleService.review(schedule.getId());
    }
    private VacationSchedule findById(Long id){
        var schedule = getAll().stream().filter(s-> s.getEmployee().getId().equals(authenticatedService.getEmployeeId()) && s.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        return schedule;
    }

}
