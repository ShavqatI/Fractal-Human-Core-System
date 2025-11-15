package com.fractal.domain.vacation_management.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.Vacation;
import com.fractal.domain.vacation_management.category.VacationCategoryService;
import com.fractal.domain.vacation_management.dto.VacationRequest;
import com.fractal.domain.vacation_management.dto.VacationResponse;
import com.fractal.domain.vacation_management.order.mapper.VacationOrderMapperService;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class VacationMapperServiceImpl implements VacationMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;
    private final VacationTypeService vacationTypeService;
    private final VacationCategoryService vacationCategoryService;
    private final VacationOrderMapperService orderMapperService;

    @Override
    public VacationResponse toDTO(Vacation vacation) {
        return new VacationResponse(
                vacation.getId(),
                employeeService.toCompactDTO(vacation.getEmployee()),
                employeeService.toCompactDTO(vacation.getSuccessorEmployee()),
                vacationCategoryService.toDTO(vacation.getVacationCategory()),
                vacationTypeService.toDTO(vacation.getVacationType()),
                vacation.getStartDate(),
                vacation.getEndDate(),
                vacation.getDays(),
                vacation.getDescription(),
                Optional.ofNullable(vacation.getOrders())
                        .orElse(emptyList())
                        .stream()
                        .map(orderMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(vacation.getStatus()),
                vacation.getCreatedDate()
        );
    }

    @Override
    public Vacation toEntity(VacationRequest dto) {
        return mapToEntity(new Vacation(),dto);
    }

    @Override
    public Vacation toEntity(Vacation vacation, VacationRequest dto) {
        return mapToEntity(vacation,dto);
    }

    private Vacation mapToEntity(Vacation vacation, VacationRequest dto) {
        vacation.setEmployee(employeeService.getById(dto.employeeId()));
        vacation.setSuccessorEmployee(employeeService.getById(dto.successorEmployeeId()));
        vacation.setVacationType(vacationTypeService.getById(dto.vacationTypeId()));
        vacation.setVacationCategory(vacationCategoryService.getById(dto.vacationCategoryId()));
        vacation.setStatus(statusService.getById(dto.statusId()));
        vacation.setStartDate(dto.startDate());
        vacation.setEndDate(dto.endDate());
        vacation.setDays(dto.days());
        vacation.setDescription(dto.description());
        return vacation;
    }
}
