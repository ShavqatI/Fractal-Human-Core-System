package com.fractal.domain.employee_management.employee.resource.mapper;

import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeResourceMapperService {
    ResourceResponse toDTO(EmployeeResource resource);
    EmployeeResource toEntity(ResourceRequest dto);
    EmployeeResource toEntity(MultipartFile file, String url);
    EmployeeResource toEntity(EmployeeResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


