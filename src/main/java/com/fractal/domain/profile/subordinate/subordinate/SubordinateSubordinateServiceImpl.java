package com.fractal.domain.profile.subordinate.subordinate;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.subordinate.Subordinate;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;
import com.fractal.domain.profile.subordinate.vacation.request.SubordinateVacationRequestRequest;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class SubordinateSubordinateServiceImpl implements SubordinateSubordinateService {

    private final AuthenticatedService authenticatedService;
    private final SubordinateService subordinateService;


    @Override
    public List<Subordinate> getAll() {
        return subordinateService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public List<Employee> getAllActiveEmployees() {
        return subordinateService.getActiveEmployees(authenticatedService.getEmployeeId());
    }

    @Override
    public Subordinate getById(Long id) {
        return null;
    }

    @Override
    public SubordinateResponse toDTO(Subordinate subordinate) {
        return subordinateService.toDTO(subordinate);
    }
}
