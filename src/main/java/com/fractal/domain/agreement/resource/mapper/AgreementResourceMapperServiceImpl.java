package com.fractal.domain.agreement.resource.mapper;

import com.fractal.domain.agreement.resource.AgreementResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class AgreementResourceMapperServiceImpl implements AgreementResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(AgreementResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public AgreementResource toEntity(ResourceRequest dto) {
        return (AgreementResource) mapperService.toEntity(dto);
    }

    @Override
    public AgreementResource toEntity(MultipartFile file, String url) {
        return (AgreementResource) mapperService.toEntity(file,url);
    }

    @Override
    public AgreementResource toEntity(AgreementResource resource, ResourceRequest dto) {
        return (AgreementResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
