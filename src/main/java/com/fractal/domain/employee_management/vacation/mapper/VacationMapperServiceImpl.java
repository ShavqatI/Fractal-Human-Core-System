package com.fractal.domain.employee_management.vacation.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.vacation.Vacation;
import com.fractal.domain.employee_management.vacation.category.VacationCategoryService;
import com.fractal.domain.employee_management.vacation.dto.VacationRequest;
import com.fractal.domain.employee_management.vacation.dto.VacationResponse;
import com.fractal.domain.employee_management.vacation.type.VacationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VacationMapperServiceImpl implements VacationMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;
    private final VacationTypeService vacationTypeService;
    private final VacationCategoryService vacationCategoryService;

    @Override
    public VacationResponse toDTO(Vacation vacation) {
        return new VacationResponse(
                vacation.getId(),
                vacation.getEmployee().getFirstName(),
                vacation.getSuccessorEmployee().getFirstName(),
                vacationCategoryService.toDTO(vacation.getVacationCategory()),
                vacationTypeService.toDTO(vacation.getVacationType()),
                statusService.toDTO(vacation.getStatus()),
                vacation.getStartDate(),
                vacation.getEndDate(),
                vacation.getDays(),
                vacation.getOrderNumber(),
                vacation.getOrderDate(),
                vacation.getDescription(),
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
        vacation.setOrderNumber(dto.orderNumber());
        vacation.setOrderDate(dto.orderDate());
        vacation.setDescription(dto.description());
        return vacation;
    }
}
