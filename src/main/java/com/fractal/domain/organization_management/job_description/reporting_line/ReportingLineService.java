package com.fractal.domain.organization_management.job_description.reporting_line;

import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineResponse;
import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;

import java.util.List;

public interface ReportingLineService {

    ReportingLine create(Long jobDescriptionId, ReportingLineRequest dto);
    List<ReportingLine> getAllByJobDescriptionId(Long jobDescriptionId);
    ReportingLine getById(Long jobDescriptionId ,Long id);
    ReportingLine update(Long jobDescriptionId,Long id, ReportingLineRequest dto);
    void delete(Long jobDescriptionId, Long id);
    ReportingLineResponse toDTO(ReportingLine reportingLine);
}
