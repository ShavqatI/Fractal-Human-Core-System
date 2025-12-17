package com.fractal.domain.employment.state;

import com.fractal.domain.employment.Employment;

import java.util.List;

public interface EmploymentStateService {
    EmploymentState create(Employment employment);

    List<EmploymentState> getAll();

    EmploymentState getById(Long id);

    List<EmploymentState> getAllByEmploymentId(Long employmentId);

    EmploymentState update(Long id, Employment employment);

    void deleteById(Long id);

    EmploymentStateResponse toDTO(EmploymentState state);

    EmploymentState save(EmploymentState state);
}
