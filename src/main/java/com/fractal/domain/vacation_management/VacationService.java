package com.fractal.domain.vacation_management;

import com.fractal.domain.vacation_management.dto.VacationRequest;
import com.fractal.domain.vacation_management.dto.VacationResponse;

import java.util.List;

public interface VacationService {
    Vacation create(VacationRequest dto);
    List<Vacation> getAll();
    Vacation getById(Long id);
    List<Vacation>  getAllByEmployeeId(Long employeeId);
    Vacation update(Long id, VacationRequest dto);
    void deleteById(Long id);
    VacationResponse toDTO(Vacation vacation);
    Vacation save(Vacation vacation);
}
