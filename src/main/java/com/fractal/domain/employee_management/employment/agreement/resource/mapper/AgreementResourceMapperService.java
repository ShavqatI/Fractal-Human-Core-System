package com.fractal.domain.employee_management.employment.agreement.resource.mapper;

import com.fractal.domain.employee_management.employment.agreement.resource.AgreementResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AgreementResourceMapperService {
    ResourceResponse toDTO(AgreementResource resource);
    AgreementResource toEntity(ResourceRequest dto);
    AgreementResource toEntity(MultipartFile file, String url);
    AgreementResource toEntity(AgreementResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


