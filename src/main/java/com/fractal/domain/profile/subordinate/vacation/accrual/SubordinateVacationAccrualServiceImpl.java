package com.fractal.domain.profile.subordinate.vacation.accrual;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class SubordinateVacationAccrualServiceImpl implements SubordinateVacationAccrualService {

    private final VacationAccrualService vacationAccrualService;
    private final AuthenticatedService authenticatedService;
    private final SubordinateService subordinateService;

    @Override
    public List<VacationAccrual> getAll() {
        var subordinates = subordinateService.getActiveEmployees(authenticatedService.getEmployeeId());
        List<VacationAccrual> vacationAccruals = new ArrayList<>();
        subordinates.forEach(employee -> vacationAccruals.addAll(
                vacationAccrualService.getAllByEmployeeId(employee.getId())
                        .stream()
                        .sorted(Comparator.comparing(VacationAccrual::getId).reversed())
                        .collect(Collectors.toList())
        ));
        return vacationAccruals;
    }

    @Override
    public List<VacationAccrual> getAllActivePeriodByEmployeeId(Long employeeId) {
        var employee = getSubordinateEmployee(employeeId);
        return vacationAccrualService.getAllActivePeriodByEmployeeId(employee.getId());
    }

    @Override
    public int getAllEmployeeRemainingDays(Long employeeId) {
        var employee = getSubordinateEmployee(employeeId);
        return vacationAccrualService.getAllEmployeeRemainingDays(employee.getId());
    }

    @Override
    public int getAllEmployeeRemainingDaysForCompensation(Long employeeId) {
        var employee = getSubordinateEmployee(employeeId);
        return vacationAccrualService.getAllEmployeeRemainingDaysForCompensation(employee.getId());
    }

    @Override
    public int getAllEmployeeRemainingPayableDays(Long employeeId) {
        var employee = getSubordinateEmployee(employeeId);
        return vacationAccrualService.getAllEmployeeRemainingPayableDays(employee.getId());

    }

    @Override
    public int getAllEmployeeRemainingUnPayableDays(Long employeeId) {
        var employee = getSubordinateEmployee(employeeId);
        return vacationAccrualService.getAllEmployeeRemainingUnPayableDays(employee.getId());

    }

    @Override
    public VacationAccrualResponse toDTO(VacationAccrual vacationAccrual) {
        return vacationAccrualService.toDTO(vacationAccrual);
    }

    private Employee getSubordinateEmployee(Long employeeId){
        var employee = subordinateService.getActiveEmployees(authenticatedService.getEmployeeId())
                .stream().filter(e-> e.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(()->new ResourceNotFoundException("Employee with id: " + employeeId + " does not exists in subordinate list"));
        return employee;
    }

}
