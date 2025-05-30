package com.fractal.domain.employee_management.employment.agreement.resource;

import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AgreementResourceService {

    ResourceResponse toDTO(AgreementResource resource);
    AgreementResource toEntity(ResourceRequest dto);
    AgreementResource toEntity(MultipartFile file, String url);
    AgreementResource update(AgreementResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    void delete(AgreementResource resource);
}
