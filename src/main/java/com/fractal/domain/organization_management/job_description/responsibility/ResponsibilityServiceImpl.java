package com.fractal.domain.organization_management.job_description.responsibility;

import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ResponsibilityServiceImpl implements ResponsibilityService  {

    private final ResponsibilityRepository responsibilityRepository;
    @Override
    public ResponsibilityResponse toDTO(Responsibility responsibility) {
        return new ResponsibilityResponse(
                responsibility.getId(),
                responsibility.getDescription(),
                responsibility.getCreatedDate()
        );
    }

    @Override
    public Responsibility toEntity(ResponsibilityRequest dto) {
        return Responsibility.builder().description(dto.description()).build();
    }

    @Override
    public Responsibility findById(Long id) {
        return responsibilityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Responsibility with id: " + id + " not found"));
    }

    @Override
    public void delete(Responsibility responsibility) {
        responsibilityRepository.delete(responsibility);
    }
}
