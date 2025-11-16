package com.fractal.domain.employee_management.employment.usecase.hire;

public interface EmployeeEmploymentUseCaseService {
    void hirePermanent(Long employeeId);

    void hirePermanentWithSurcharge(Long employeeId);

    void hireTemporary(Long employeeId);

    void hireTemporaryWithSurcharge(Long employeeId);

    void offBoard(Long employeeId);

    void transferInternal(Long employeeId);

    void transferInterOrganization(Long employeeId);

    void rotate(Long employeeId);


}
