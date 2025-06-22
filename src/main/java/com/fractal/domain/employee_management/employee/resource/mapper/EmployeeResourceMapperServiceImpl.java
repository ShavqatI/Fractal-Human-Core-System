package com.fractal.domain.employee_management.employee.resource.mapper;

import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class EmployeeResourceMapperServiceImpl implements EmployeeResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(EmployeeResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public EmployeeResource toEntity(ResourceRequest dto) {
        return (EmployeeResource) mapperService.toEntity(dto);
    }

    @Override
    public EmployeeResource toEntity(MultipartFile file, String url) {
        return (EmployeeResource) mapperService.toEntity(file,url);
    }

    @Override
    public EmployeeResource toEntity(EmployeeResource resource, ResourceRequest dto) {
        return (EmployeeResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
