package com.fractal.domain.organization_management.job_description.accountability;

import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityResponse;

import java.util.List;

public interface AccountabilityService {

    Accountability create(Long jobDescriptionId, AccountabilityRequest dto);

    List<Accountability> getAllByJobDescriptionId(Long jobDescriptionId);

    Accountability getById(Long jobDescriptionId, Long id);

    Accountability update(Long jobDescriptionId, Long id, AccountabilityRequest dto);

    void delete(Long jobDescriptionId, Long id);

    AccountabilityResponse toDTO(Accountability accountability);
}
