package com.fractal.domain.employment.internal.agreement.resource.mapper;

import com.fractal.domain.employment.internal.agreement.resource.InternalEmploymentAgreementResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class InternalEmploymentAgreementResourceMapperServiceImpl implements InternalEmploymentAgreementResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(InternalEmploymentAgreementResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public InternalEmploymentAgreementResource toEntity(ResourceRequest dto) {
        return (InternalEmploymentAgreementResource) mapperService.toEntity(dto);
    }

    @Override
    public InternalEmploymentAgreementResource toEntity(MultipartFile file, String url) {
        return (InternalEmploymentAgreementResource) mapperService.toEntity(file,url);
    }

    @Override
    public InternalEmploymentAgreementResource toEntity(InternalEmploymentAgreementResource resource, ResourceRequest dto) {
        return (InternalEmploymentAgreementResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
