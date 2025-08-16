package com.fractal.domain.employee_management.citizenship;



import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;

import java.util.List;

public interface EmployeeCitizenshipService {

    EmployeeCitizenship create(Long employeeId, CitizenshipRequest dto);
    List<EmployeeCitizenship> getAllByEmployeeId(Long employeeId);
    EmployeeCitizenship getById(Long employeeId , Long id);
    EmployeeCitizenship update(Long employeeId, Long id, CitizenshipRequest dto);
    void delete(Long employeeId,Long id);
    CitizenshipResponse toDTO(EmployeeCitizenship employeeCitizenship);

}
