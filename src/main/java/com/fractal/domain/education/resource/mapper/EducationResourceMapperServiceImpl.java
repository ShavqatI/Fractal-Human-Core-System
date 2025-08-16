package com.fractal.domain.education.resource.mapper;

import com.fractal.domain.education.resource.EducationResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class EducationResourceMapperServiceImpl implements EducationResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(EducationResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public EducationResource toEntity(ResourceRequest dto) {
        return (EducationResource) mapperService.toEntity(dto);
    }

    @Override
    public EducationResource toEntity(MultipartFile file, String url) {
        return (EducationResource) mapperService.toEntity(file,url);
    }

    @Override
    public EducationResource toEntity(EducationResource resource, ResourceRequest dto) {
        return (EducationResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
