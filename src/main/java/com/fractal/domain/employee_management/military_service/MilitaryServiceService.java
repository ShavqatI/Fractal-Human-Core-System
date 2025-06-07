package com.fractal.domain.employee_management.military_service;

import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceResponse;
import org.springframework.web.multipart.MultipartFile;


public interface MilitaryServiceService {
    MilitaryService create(MilitaryServiceRequest dto);
    MilitaryServiceResponse toDTO(MilitaryService militaryService);
    MilitaryService toEntity(MilitaryServiceRequest dto);
    MilitaryService update(Long id,MilitaryServiceRequest dto);
    void delete(MilitaryService militaryService);
    MilitaryService addResource(Long id, MultipartFile file, String url);
    MilitaryService updateResource(Long id, Long resourceId, MultipartFile file);
    MilitaryService deleteResource(Long id, Long resourceId);
}
