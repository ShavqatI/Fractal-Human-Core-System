package com.fractal.domain.employment.internal.agreement.resource.mapper;

import com.fractal.domain.employment.internal.agreement.resource.InternalEmploymentAgreementResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface InternalEmploymentAgreementResourceMapperService {
    ResourceResponse toDTO(InternalEmploymentAgreementResource resource);
    InternalEmploymentAgreementResource toEntity(ResourceRequest dto);
    InternalEmploymentAgreementResource toEntity(MultipartFile file, String url);
    InternalEmploymentAgreementResource toEntity(InternalEmploymentAgreementResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


