package com.fractal.domain.employee_management.employee.resource;

import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeResourceService {

    ResourceResponse toDTO(EmployeeResource resource);
    EmployeeResource toEntity(ResourceRequest dto);
    EmployeeResource toEntity(MultipartFile file, String url);
    EmployeeResource update(EmployeeResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    void delete(EmployeeResource resource);
    EmployeeResource findById(Long id);
}
