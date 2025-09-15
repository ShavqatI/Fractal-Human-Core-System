package com.fractal.domain.employee_management.business_trip.expense.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BusinessTripExpenseResourceService {

    BusinessTripExpenseResource create(Long businessTripExpenseId, MultipartFile file);
    List<BusinessTripExpenseResource> getAllByBusinessTripExpenseId(Long businessTripExpenseId);
    BusinessTripExpenseResource getById(Long businessTripExpenseId , Long id);
    BusinessTripExpenseResource update(Long businessTripExpenseId, Long id, MultipartFile file);
    void delete(Long businessTripExpenseId,Long id);
    ResourceResponse toDTO(BusinessTripExpenseResource resource);

}
