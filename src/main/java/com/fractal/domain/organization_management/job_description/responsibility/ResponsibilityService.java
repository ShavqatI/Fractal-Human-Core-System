package com.fractal.domain.organization_management.job_description.responsibility;

import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;

import java.util.List;

public interface ResponsibilityService {

    Responsibility create(Long jobDescriptionId, ResponsibilityRequest dto);

    List<Responsibility> getAllByJobDescriptionId(Long jobDescriptionId);

    Responsibility getById(Long jobDescriptionId, Long id);

    Responsibility update(Long jobDescriptionId, Long id, ResponsibilityRequest dto);

    void delete(Long jobDescriptionId, Long id);

    ResponsibilityResponse toDTO(Responsibility responsibility);
}
