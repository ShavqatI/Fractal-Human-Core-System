package com.fractal.domain.employee_management.employee.resource.mapper;

import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceRequest;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;
import com.fractal.domain.employee_management.employee.resource.type.EmployeeResourceTypeService;
import com.fractal.domain.resource.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeResourceMapperServiceImpl implements EmployeeResourceMapperService {


    private final EmployeeResourceTypeService resourceTypeService;
    private final FileService fileService;
    @Value("${resource-storage.employee}")
    private String resourceStoragePath;
    @Override
    public EmployeeResourceResponse toDTO(EmployeeResource resource) {
        return new EmployeeResourceResponse(
                resource.getId(),
                resourceTypeService.toDTO(resource.getEmployeeResourceType()),
                resource.getUrl(),
                resource.getFileName(),
                resource.getContentType(),
                resource.getSizeInBytes(),
                resource.getCreatedDate()
        );
    }

    @Override
    public EmployeeResource toEntity(EmployeeResourceRequest dto, String url) {
        return mapToEntity(new EmployeeResource(),dto,url);
    }

    @Override
    public EmployeeResource toEntity(EmployeeResource resource, EmployeeResourceRequest dto,String url) {
        return mapToEntity(resource,dto,url);
    }

    private EmployeeResource mapToEntity(EmployeeResource resource, EmployeeResourceRequest dto,String url) {
        fileService.delete(resource.getUrl());
        resource.setEmployeeResourceType(resourceTypeService.getById(dto.employeeResourceTypeId()));
        resource.setUrl(url);
        resource.setFileName(dto.file().getOriginalFilename());
        resource.setContentType(dto.file().getContentType());
        resource.setSizeInBytes(dto.file().getSize());
        resource.setUrl(fileService.save(dto.file(), resourceStoragePath));
        return resource;
    }
}
