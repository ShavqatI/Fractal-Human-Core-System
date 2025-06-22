package com.fractal.domain.employee_management.employee;

import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    Employee create(EmployeeRequest dto);
    List<Employee> getAll();
    Employee getByTin(String tin);
    Employee getById(Long id);
    Employee update(Long id, EmployeeRequest dto);
    void deleteById(Long id);
    EmployeeResponse toDTO(Employee employee);
    Employee save(Employee employee);

    Employee addMilitaryService(Long id, MilitaryServiceRequest dto);
    Employee updateMilitaryService(Long id,Long militaryServiceId, MilitaryServiceRequest dto);
    Employee deleteMilitaryService(Long id,Long militaryServiceId);

    Employee addEmploymentHistory(Long id, EmploymentHistoryRequest dto);
    Employee updateEmploymentHistory(Long id,Long employmentHistoryId, EmploymentHistoryRequest dto);
    Employee deleteEmploymentHistory(Long id,Long employmentHistoryId);

    Employee addResource(Long id, MultipartFile file, String url);
    Employee updateResource(Long id, Long resourceId, MultipartFile file);
    Employee deleteResource(Long id, Long resourceId);
}
