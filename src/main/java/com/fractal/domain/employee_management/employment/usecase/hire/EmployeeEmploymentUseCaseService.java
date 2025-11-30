package com.fractal.domain.employee_management.employment.usecase.hire;

import com.fractal.domain.employee_management.employment.usecase.hire.dto.Hire;

public interface EmployeeEmploymentUseCaseService {
    void hire(Long employeeId, Hire dto);
    /*void hirePermanent(Long employeeId);

    void hirePermanentWithSurcharge(Long employeeId);

    void hireTemporary(Long employeeId);

    void hireTemporaryWithSurcharge(Long employeeId);

    void offBoard(Long employeeId);

    void transferInternal(Long employeeId, InternalTransfer dto);

    void transferInterOrganization(Long employeeId, InterOrganizationTransfer dto);

    void rotate(Long employeeId);*/


}
