package com.fractal.domain.employee_management.business_trip.resource.mapper;

import com.fractal.domain.employee_management.business_trip.resource.BusinessTripResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class BusinessTripResourceMapperServiceImpl implements BusinessTripResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(BusinessTripResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public BusinessTripResource toEntity(ResourceRequest dto) {
        return (BusinessTripResource) mapperService.toEntity(dto);
    }

    @Override
    public BusinessTripResource toEntity(MultipartFile file, String url) {
        return (BusinessTripResource) mapperService.toEntity(file,url);
    }

    @Override
    public BusinessTripResource toEntity(BusinessTripResource resource, ResourceRequest dto) {
        return (BusinessTripResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
