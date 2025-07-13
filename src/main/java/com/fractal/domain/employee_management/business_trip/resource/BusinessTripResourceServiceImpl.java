package com.fractal.domain.employee_management.business_trip.resource;

import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.resource.mapper.BusinessTripResourceMapperService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripResourceServiceImpl implements BusinessTripResourceService {

    private final BusinessTripResourceRepository resourceRepository;
    private final BusinessTripResourceMapperService resourceMapperService;
    private final BusinessTripService businessTripService;

    @Override
    public BusinessTripResource create(Long employeeId, MultipartFile file) {
        var businessTrip = businessTripService.getById(employeeId);
        var resource = resourceMapperService.toEntity(file,null);
        businessTrip.addResource(resource);
        businessTripService.save(businessTrip);
        return resource;
    }

    @Override
    public List<BusinessTripResource> getAllByBusinessTripId(Long businessTripId) {
        return resourceRepository.findAllByBusinessTripId(businessTripId);
    }

    @Override
    public BusinessTripResource getById(Long businessTripId, Long id) {
        return resourceRepository.findByBusinessTripIdAndId(businessTripId,id).orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource with id: " + id + " not found"));
    }

    @Override
    public BusinessTripResource update(Long employeeId, Long id, MultipartFile file) {
        var businessTrip = businessTripService.getById(employeeId);
        var resource = businessTrip.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,resourceMapperService.fileToRequest(file,null));
        resourceRepository.save(resource);
        businessTripService.save(businessTrip);
        return resource;
    }

    @Override
    public void delete(Long employeeId, Long id) {
        var businessTrip = businessTripService.getById(employeeId);
        var resource = businessTrip.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Resource  with id: " + id + " not found"));
        resourceRepository.delete(resource);
        businessTripService.save(businessTrip);
    }

    @Override
    public ResourceResponse toDTO(BusinessTripResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
