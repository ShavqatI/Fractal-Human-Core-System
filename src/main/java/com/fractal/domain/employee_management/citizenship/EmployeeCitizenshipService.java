package com.fractal.domain.employee_management.citizenship;

import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipResponse;

import java.util.List;

public interface EmployeeCitizenshipService {

    EmployeeCitizenship create(Long employeeId, EmployeeCitizenshipRequest dto);
    List<EmployeeCitizenship> getAllByEmployeeId(Long employeeId);
    EmployeeCitizenship getById(Long employeeId , Long id);
    EmployeeCitizenship update(Long employeeId, Long id, EmployeeCitizenshipRequest dto);
    void delete(Long employeeId,Long id);
    EmployeeCitizenshipResponse toDTO(EmployeeCitizenship employeeCitizenship);

}
