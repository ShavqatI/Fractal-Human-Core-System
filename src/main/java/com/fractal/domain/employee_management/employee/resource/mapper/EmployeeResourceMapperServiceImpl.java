package com.fractal.domain.employee_management.employee.resource.mapper;

import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceRequest;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;
import com.fractal.domain.employee_management.employee.resource.type.EmployeeResourceTypeService;
import com.fractal.domain.resource.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
class EmployeeResourceMapperServiceImpl implements EmployeeResourceMapperService {


    private final EmployeeResourceTypeService resourceTypeService;
    private final FileService fileService;
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
        resource.setEmployeeResourceType(resourceTypeService.getById(dto.employeeResourceTypeId()));
        resource.setUrl(url);
        resource.setFileName(dto.file().getOriginalFilename());
        resource.setContentType(dto.file().getContentType());
        resource.setSizeInBytes(dto.file().getSize());
        resource.setUrl(fileService.save(dto.file(),"C:\\My Data\\fractal\\2025\\Fractal-Human-Core-System\\src\\main\\resources\\static\\employee\\"));
        return resource;
    }

    private String saveFile(MultipartFile file,String dirPath) {
        var uploadPath = Path.of(dirPath);
        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
