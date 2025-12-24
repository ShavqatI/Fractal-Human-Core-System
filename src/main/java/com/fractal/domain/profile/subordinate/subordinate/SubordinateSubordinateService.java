package com.fractal.domain.profile.subordinate.subordinate;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.subordinate.Subordinate;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;
import com.fractal.domain.profile.subordinate.vacation.request.SubordinateVacationRequestRequest;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;

import java.util.List;

public interface SubordinateSubordinateService{
    List<Subordinate> getAll();
    List<Employee> getAllActiveEmployees();
    Subordinate getById(Long id);
    SubordinateResponse toDTO(Subordinate subordinate);

}
