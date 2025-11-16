package com.fractal.domain.vacation_management.vacation.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.vacation.Vacation;
import com.fractal.domain.vacation_management.category.VacationCategoryService;
import com.fractal.domain.vacation_management.vacation.dto.VacationRequest;
import com.fractal.domain.vacation_management.vacation.dto.VacationResponse;
import com.fractal.domain.vacation_management.vacation.order.mapper.VacationOrderMapperService;
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
    private final VacationRequestService vacationRequestService;
    private final VacationOrderMapperService orderMapperService;

    @Override
    public VacationResponse toDTO(Vacation vacation) {
        return new VacationResponse(
                vacation.getId(),
                employeeService.toCompactDTO(vacation.getEmployee()),
                vacationRequestService.toDTO(vacation.getVacationRequest()),
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
        return mapToEntity(new Vacation(), dto);
    }

    @Override
    public Vacation toEntity(Vacation vacation, VacationRequest dto) {
        return mapToEntity(vacation, dto);
    }

    private Vacation mapToEntity(Vacation vacation, VacationRequest dto) {
        var request = vacationRequestService.getById(dto.vacationRequestId());
        vacation.setEmployee(request.getEmployee());
        vacation.setVacationRequest(request);
        return vacation;
    }
}
