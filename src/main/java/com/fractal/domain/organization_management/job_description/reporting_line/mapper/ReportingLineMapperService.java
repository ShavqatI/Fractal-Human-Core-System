package com.fractal.domain.organization_management.job_description.reporting_line.mapper;

import com.fractal.domain.organization_management.job_description.reporting_line.ReportingLine;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineResponse;

public interface ReportingLineMapperService {
    ReportingLineResponse toDTO(ReportingLine reportingLine);
    ReportingLine toEntity(ReportingLineRequest dto);
    ReportingLine toEntity(ReportingLine reportingLine, ReportingLineRequest dto);
}


