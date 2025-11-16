package com.fractal.domain.employee_management.business_trip.resource.mapper;

import com.fractal.domain.employee_management.business_trip.resource.BusinessTripResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface BusinessTripResourceMapperService {
    ResourceResponse toDTO(BusinessTripResource resource);

    BusinessTripResource toEntity(ResourceRequest dto);

    BusinessTripResource toEntity(MultipartFile file, String resourceStoragePath);

    BusinessTripResource toEntity(BusinessTripResource resource, MultipartFile file, String resourceStoragePath);

    BusinessTripResource toEntity(BusinessTripResource resource, ResourceRequest dto);

    ResourceRequest fileToRequest(MultipartFile file, String url);
}


