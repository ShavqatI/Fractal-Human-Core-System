package com.fractal.domain.employee_management.business_trip.resource.mapper;

import com.fractal.domain.employee_management.business_trip.resource.BusinessTripResource;
import com.fractal.domain.resource.Resource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class BusinessTripResourceMapperServiceImpl implements BusinessTripResourceMapperService {

    private final ResourceMapperService resourceMapperService;

    @Override
    public ResourceResponse toDTO(BusinessTripResource resource) {
        return resourceMapperService.toDTO(resource);
    }

    @Override
    public BusinessTripResource toEntity(ResourceRequest dto) {
        return (BusinessTripResource) resourceMapperService.toEntity(dto);
    }

    @Override
    public BusinessTripResource toEntity(MultipartFile file, String resourceStoragePath) {
        return convert(new BusinessTripResource(),resourceMapperService.toEntity(file,resourceStoragePath));
    }

    @Override
    public BusinessTripResource toEntity(BusinessTripResource resource, MultipartFile file, String resourceStoragePath) {
        return convert(resource,resourceMapperService.toEntity(resource,file,resourceStoragePath));
    }

    @Override
    public BusinessTripResource toEntity(BusinessTripResource resource, ResourceRequest dto) {
        return (BusinessTripResource) resourceMapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return resourceMapperService.fileToRequest(file,url);
    }

    private BusinessTripResource convert(BusinessTripResource businessTripResource, Resource resource) {
        businessTripResource.setFileName(resource.getFileName());
        businessTripResource.setContentType(resource.getContentType());
        businessTripResource.setSizeInBytes(resource.getSizeInBytes());
        businessTripResource.setUrl(resource.getUrl());
        return businessTripResource;
    }
}
