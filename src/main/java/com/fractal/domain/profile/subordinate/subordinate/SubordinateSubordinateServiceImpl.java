package com.fractal.domain.profile.subordinate.subordinate;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.subordinate.Subordinate;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
