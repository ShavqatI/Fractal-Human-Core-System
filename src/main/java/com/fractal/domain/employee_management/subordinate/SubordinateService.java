package com.fractal.domain.employee_management.subordinate;

import com.fractal.domain.employee_management.subordinate.dto.SubordinateRequest;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;

import java.time.LocalDate;
import java.util.List;

public interface SubordinateService {
    Subordinate create(SubordinateRequest dto);

    List<Subordinate> getAll();

    Subordinate getById(Long id);
    Subordinate getActiveByEmployeeId(Long employeeId);

    List<Subordinate> getAllByEmployeeId(Long employeeId);

    Subordinate update(Long id, SubordinateRequest dto);

    void deleteById(Long id);
    void close(Long id, LocalDate endDate);

    SubordinateResponse toDTO(Subordinate subordinate);
}
