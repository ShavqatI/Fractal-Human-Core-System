package com.fractal.domain.agreement.resource.mapper;

import com.fractal.domain.agreement.resource.AgreementResource;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class AgreementResourceMapperServiceImpl implements AgreementResourceMapperService {

    private final ResourceMapperService resourceMapperService;

    @Override
    public ResourceResponse toDTO(AgreementResource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public AgreementResource toEntity(ResourceRequest dto) {
        return (AgreementResource) resourceMapperService.toEntity(dto);
    }

    @Override
    public AgreementResource toEntity(MultipartFile file, String resourceStoragePath) {
        return convert(new AgreementResource(),resourceMapperService.toEntity(file,resourceStoragePath));
    }

    @Override
    public AgreementResource toEntity(AgreementResource resource, MultipartFile file, String resourceStoragePath) {
        return convert(resource,resourceMapperService.toEntity(resource,file,resourceStoragePath));
    }

    @Override
    public AgreementResource toEntity(AgreementResource resource, ResourceRequest dto) {
        return (AgreementResource) resourceMapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file,url);
    }

    private AgreementResource convert(AgreementResource agreementResource, Resource resource) {
        agreementResource.setFileName(resource.getFileName());
        agreementResource.setContentType(resource.getContentType());
        agreementResource.setSizeInBytes(resource.getSizeInBytes());
        agreementResource.setUrl(resource.getUrl());
        return agreementResource;
    }
}
