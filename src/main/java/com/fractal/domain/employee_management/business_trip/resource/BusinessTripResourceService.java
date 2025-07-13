package com.fractal.domain.employee_management.business_trip.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BusinessTripResourceService {

    BusinessTripResource create(Long businessTripId, MultipartFile file);
    List<BusinessTripResource> getAllByBusinessTripId(Long businessTripId);
    BusinessTripResource getById(Long businessTripId , Long id);
    BusinessTripResource update(Long businessTripId, Long id, MultipartFile file);
    void delete(Long businessTripId,Long id);
    ResourceResponse toDTO(BusinessTripResource resource);

}
