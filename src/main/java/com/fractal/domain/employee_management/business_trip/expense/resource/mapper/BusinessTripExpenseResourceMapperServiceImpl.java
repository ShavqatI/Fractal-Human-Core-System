package com.fractal.domain.employee_management.business_trip.expense.resource.mapper;

import com.fractal.domain.employee_management.business_trip.expense.resource.BusinessTripExpenseResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class BusinessTripExpenseResourceMapperServiceImpl implements BusinessTripExpenseResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(BusinessTripExpenseResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public BusinessTripExpenseResource toEntity(ResourceRequest dto) {
        return (BusinessTripExpenseResource) mapperService.toEntity(dto);
    }

    @Override
    public BusinessTripExpenseResource toEntity(MultipartFile file, String url) {
        return (BusinessTripExpenseResource) mapperService.toEntity(file,url);
    }

    @Override
    public BusinessTripExpenseResource toEntity(BusinessTripExpenseResource resource, ResourceRequest dto) {
        return (BusinessTripExpenseResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
