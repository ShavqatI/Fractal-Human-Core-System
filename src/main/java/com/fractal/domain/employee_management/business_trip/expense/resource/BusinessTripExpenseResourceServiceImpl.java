package com.fractal.domain.employee_management.business_trip.expense.resource;

import com.fractal.domain.employee_management.business_trip.expense.BusinessTripExpenseService;
import com.fractal.domain.employee_management.business_trip.expense.resource.mapper.BusinessTripExpenseResourceMapperService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripExpenseResourceServiceImpl implements BusinessTripExpenseResourceService {

    private final BusinessTripExpenseResourceRepository resourceRepository;
    private final BusinessTripExpenseResourceMapperService resourceMapperService;
    private final BusinessTripExpenseService businessTripExpenseService;

    @Override
    public BusinessTripExpenseResource create(Long businessTripExpenseId, MultipartFile file) {
        var expense = businessTripExpenseService.getById(businessTripExpenseId);
        var resource = resourceMapperService.toEntity(file,null);
        expense.addResource(resource);
        businessTripExpenseService.save(expense);
        return resource;
    }

    @Override
    public List<BusinessTripExpenseResource> getAllByBusinessTripExpenseId(Long businessTripExpenseId) {
        return resourceRepository.findAllByBusinessTripExpenseId(businessTripExpenseId);
    }

    @Override
    public BusinessTripExpenseResource getById(Long businessTripExpenseId, Long id) {
        return resourceRepository.findByByBusinessTripExpenseIdAndId(businessTripExpenseId,id).orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource with id: " + id + " not found"));
    }

    @Override
    public BusinessTripExpenseResource update(Long businessTripExpenseId, Long id, MultipartFile file) {
        var expense = businessTripExpenseService.getById(businessTripExpenseId);
        var resource = expense.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,resourceMapperService.fileToRequest(file,null));
        businessTripExpenseService.save(expense);
        return resource;
    }

    @Override
    public void delete(Long businessTripExpenseId, Long id) {
        var expense = businessTripExpenseService.getById(businessTripExpenseId);
        var resource = expense.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource  with id: " + id + " not found"));
        resourceRepository.delete(resource);
        businessTripExpenseService.save(expense);
    }

    @Override
    public ResourceResponse toDTO(BusinessTripExpenseResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
