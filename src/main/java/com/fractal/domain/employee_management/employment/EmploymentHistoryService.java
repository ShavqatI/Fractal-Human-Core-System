package com.fractal.domain.employee_management.employment;

import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;

import java.util.List;

public interface EmploymentHistoryService {
    EmploymentHistory create(Long employeeId, EmploymentHistoryRequest dto);
    List<EmploymentHistory> getAllByEmployeeId(Long employeeId);
    EmploymentHistory getById(Long employeeId ,Long id);
    EmploymentHistory getById(Long id);
    EmploymentHistory update(Long employeeId,Long id, EmploymentHistoryRequest dto);
    void delete(Long employeeId, Long id);
    EmploymentHistoryResponse toDTO(EmploymentHistory employmentHistory);
    EmploymentHistory save(EmploymentHistory employmentHistory);


}
