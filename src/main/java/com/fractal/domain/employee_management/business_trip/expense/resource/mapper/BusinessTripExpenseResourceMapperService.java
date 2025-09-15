package com.fractal.domain.employee_management.business_trip.expense.resource.mapper;

import com.fractal.domain.employee_management.business_trip.expense.resource.BusinessTripExpenseResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface BusinessTripExpenseResourceMapperService {
    ResourceResponse toDTO(BusinessTripExpenseResource resource);
    BusinessTripExpenseResource toEntity(ResourceRequest dto);
    BusinessTripExpenseResource toEntity(MultipartFile file, String url);
    BusinessTripExpenseResource toEntity(BusinessTripExpenseResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
}


