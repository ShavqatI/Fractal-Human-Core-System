package com.fractal.domain.vacation_management.request.mapper;

import com.fractal.domain.dictionary.calendar.holiday.HolidayCalendar;
import com.fractal.domain.dictionary.calendar.holiday.HolidayCalendarService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.domain.vacation_management.request.medical_info.mapper.VacationRequestMedicalInfoMapperService;
import com.fractal.domain.vacation_management.request.responsibility.mapper.VacationRequestResponsibilityMapperService;
import com.fractal.domain.vacation_management.request.state.VacationRequestStateService;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class VacationRequestMapperServiceImpl implements VacationRequestMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;
    private final VacationTypeService vacationTypeService;
    private final VacationRequestStateService stateService;
    private final VacationRequestResponsibilityMapperService responsibilityMapperService;
    private final VacationRequestMedicalInfoMapperService medicalInfoMapperService;
    private final HolidayCalendarService holidayCalendarService;

    @Override
    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return new VacationRequestResponse(
                vacationRequest.getId(),
                employeeService.toCompactDTO(vacationRequest.getEmployee()),
                Optional.ofNullable(vacationRequest.getSuccessorEmployee())
                        .map(employeeService::toCompactDTO)
                        .orElse(null),
                vacationTypeService.toDTO(vacationRequest.getVacationType()),
                vacationRequest.getStartDate(),
                vacationRequest.getEndDate(),
                vacationRequest.getDays(),
                vacationRequest.getWorkingDate(),
                vacationRequest.getDescription(),
                Optional.ofNullable(vacationRequest.getResponsibilities())
                        .orElse(emptyList())
                        .stream()
                        .map(responsibilityMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(vacationRequest.getMedicalInfos())
                        .orElse(emptyList())
                        .stream()
                        .map(medicalInfoMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(vacationRequest.getStates())
                        .orElse(emptyList())
                        .stream()
                        .map(stateService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(vacationRequest.getStatus()),
                vacationRequest.getCreatedDate()
        );
    }

    @Override
    public VacationRequest toEntity(VacationRequestRequest dto) {
        var request = mapToEntity(new VacationRequest(), dto);
        request.setStatus(statusService.getByCode("CREATED"));
        return request;
    }

    @Override
    public VacationRequest toEntity(VacationRequest vacationRequest, VacationRequestRequest dto) {
        return mapToEntity(vacationRequest, dto);
    }

    private VacationRequest mapToEntity(VacationRequest vacationRequest, VacationRequestRequest dto) {
        vacationRequest.setEmployee(employeeService.getById(dto.employeeId()));
        if(dto.successorEmployeeId() != null)
        vacationRequest.setSuccessorEmployee(employeeService.getById(dto.successorEmployeeId()));
        vacationRequest.setVacationType(vacationTypeService.getById(dto.vacationTypeId()));
        vacationRequest.setStartDate(dto.startDate());
        vacationRequest.setEndDate(calculateEndDate(dto.startDate(),dto.endDate()));
        vacationRequest.setDays(calculateDays(dto.startDate(),dto.endDate()));
        vacationRequest.setDescription(dto.description());
        vacationRequest.setWorkingDays(calculateWorkingDays(vacationRequest.getStartDate(),dto.endDate()));
        vacationRequest.setWorkingDate(calculateWorkingDate(vacationRequest.getEndDate()));
        dto.responsibilities().forEach(responsibility -> vacationRequest.addResponsibility(responsibilityMapperService.toEntity(responsibility)));
        dto.medicalInfos().forEach(medicalInfo -> vacationRequest.addMedicalInfo(medicalInfoMapperService.toEntity(medicalInfo)));
        return vacationRequest;
    }

    private LocalDate calculateEndDate(LocalDate startDate, LocalDate endDate) {
        List<HolidayCalendar> holidays = holidayCalendarService.getByDates(startDate,endDate);
        return endDate.plusDays(holidays.size());
    }

    private int calculateDays(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    public int countWeekdays(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        int weekdays = 0;
        for (long i = 0; i <= days; i++) {
            DayOfWeek dow = startDate.plusDays(i).getDayOfWeek();
            if (dow != DayOfWeek.SATURDAY && dow != DayOfWeek.SUNDAY) {
                weekdays++;
            }
        }
        return weekdays;
    }
    private int calculateWorkingDays(LocalDate startDate, LocalDate endDate) {
        List<HolidayCalendar> holidays = holidayCalendarService.getByDates(startDate,endDate);
        var weekDays = countWeekdays(startDate,endDate);
        return weekDays - holidays.size();
    }

    private LocalDate calculateWorkingDate(LocalDate date){
        var weekDay = getWeekDay(date);
        weekDay = isHoliday(weekDay);
        return weekDay;
    }

    private LocalDate getWeekDay(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        if (dow != DayOfWeek.SATURDAY && dow != DayOfWeek.SUNDAY) {
            return date;
        }
        else return getWeekDay(date.plusDays(1L));
    }
    private LocalDate isHoliday(LocalDate date){
        var holidayCalendar = holidayCalendarService.getByDate(date);
        if(holidayCalendar.isEmpty()) return date;
        else return isHoliday(date.plusDays(1L));
    }

}
