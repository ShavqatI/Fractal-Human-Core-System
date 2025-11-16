package com.fractal.domain.vacation_management.accrual.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualRequest;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.accrual.period.mapper.VacationAccrualPeriodMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class VacationAccrualMapperServiceImpl implements VacationAccrualMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;
    private final VacationAccrualPeriodMapperService periodMapperService;

    @Override
    public VacationAccrualResponse toDTO(VacationAccrual accrual) {
        return new VacationAccrualResponse(
                accrual.getId(),
                employeeService.toCompactDTO(accrual.getEmployee()),
                Optional.ofNullable(accrual.getPeriods())
                        .orElse(emptyList())
                        .stream()
                        .map(periodMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(accrual.getStatus()),
                accrual.getCreatedDate()
        );
    }

    @Override
    public VacationAccrual toEntity(VacationAccrualRequest dto) {
        return mapToEntity(new VacationAccrual(), dto);
    }

    @Override
    public VacationAccrual toEntity(VacationAccrual accrual, VacationAccrualRequest dto) {
        return mapToEntity(accrual, dto);
    }

    private VacationAccrual mapToEntity(VacationAccrual accrual, VacationAccrualRequest dto) {
        accrual.setEmployee(employeeService.getById(dto.employeeId()));
        accrual.setStatus(statusService.getById(dto.statusId()));
        dto.periods().forEach(period -> accrual.addPeriod(periodMapperService.toEntity(period)));
        return accrual;
    }
}
