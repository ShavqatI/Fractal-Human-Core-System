package com.fractal.domain.employee_management.vacation;

import com.fractal.domain.employee_management.vacation.dto.VacationRequest;
import com.fractal.domain.employee_management.vacation.dto.VacationResponse;

import java.util.List;

public interface VacationService {
    Vacation create(VacationRequest dto);
    List<Vacation> getAll();
    Vacation getById(Long id);
    List<Vacation>  getAllByEmployeeId(Long employeeId);
    Vacation update(Long id, VacationRequest dto);
    void deleteById(Long id);
    VacationResponse toDTO(Vacation vacation);
}
