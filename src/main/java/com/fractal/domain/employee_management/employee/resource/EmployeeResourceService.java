package com.fractal.domain.employee_management.employee.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeResourceService {

    EmployeeResource create(Long employeeId, MultipartFile file);
    List<EmployeeResource> getAllByEmployeeId(Long employeeId);
    EmployeeResource getById(Long employeeId ,Long id);
    EmployeeResource update(Long employeeId,Long id, MultipartFile file);
    void delete(Long employeeId,Long id);
    ResourceResponse toDTO(EmployeeResource resource);

}
