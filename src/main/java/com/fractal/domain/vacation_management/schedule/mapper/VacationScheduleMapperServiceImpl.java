package com.fractal.domain.vacation_management.schedule.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.schedule.VacationSchedule;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VacationScheduleMapperServiceImpl implements VacationScheduleMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;
    private final VacationTypeService vacationTypeService;

    @Override
    public VacationScheduleResponse toDTO(VacationSchedule vacationSchedule) {
        return new VacationScheduleResponse(
                vacationSchedule.getId(),
                employeeService.toCompactDTO(vacationSchedule.getEmployee()),
                vacationTypeService.toDTO(vacationSchedule.getVacationType()),
                vacationSchedule.getStartDate(),
                vacationSchedule.getEndDate(),
                vacationSchedule.getDays(),
                statusService.toCompactDTO(vacationSchedule.getStatus()),
                vacationSchedule.getCreatedDate()
        );
    }

    @Override
    public VacationSchedule toEntity(VacationScheduleRequest dto) {
        return mapToEntity(new VacationSchedule(),dto);
    }

    @Override
    public VacationSchedule toEntity(VacationSchedule vacationSchedule, VacationScheduleRequest dto) {
        return mapToEntity(vacationSchedule,dto);
    }

    private VacationSchedule mapToEntity(VacationSchedule vacationSchedule, VacationScheduleRequest dto) {
        vacationSchedule.setEmployee(employeeService.getById(dto.employeeId()));
        vacationSchedule.setVacationType(vacationTypeService.getByCode("ANNUAL"));
        vacationSchedule.setStartDate(dto.startDate());
        vacationSchedule.setEndDate(dto.endDate());
        return vacationSchedule;
    }
}
