package com.fractal.domain.employment;

public interface EmploymentService {
    Employment getById(Long id);

    Employment save(Employment employment);
}
