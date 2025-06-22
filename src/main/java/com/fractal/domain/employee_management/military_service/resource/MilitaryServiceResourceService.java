package com.fractal.domain.employee_management.military_service.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MilitaryServiceResourceService {
    MilitaryServiceResource create(Long militaryServiceId, MultipartFile file);
    List<MilitaryServiceResource> getAllByMilitaryServiceId(Long militaryServiceId);
    MilitaryServiceResource getById(Long militaryServiceId ,Long id);
    MilitaryServiceResource update(Long militaryServiceId,Long id, MultipartFile file);
    void delete(Long militaryServiceId,Long id);
    ResourceResponse toDTO(MilitaryServiceResource resource);
}
