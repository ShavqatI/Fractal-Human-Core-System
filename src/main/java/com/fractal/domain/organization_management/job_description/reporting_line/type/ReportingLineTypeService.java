package com.fractal.domain.organization_management.job_description.reporting_line.type;

import com.fractal.domain.organization_management.job_description.reporting_line.type.dto.ReportingLineTypeRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.type.dto.ReportingLineTypeResponse;

import java.util.List;

public interface ReportingLineTypeService {

    ReportingLineType create(ReportingLineTypeRequest dto);

    List<ReportingLineType> getAll();

    ReportingLineType getByCode(String code);

    ReportingLineType getById(Long id);

    ReportingLineType update(Long id, ReportingLineTypeRequest dto);

    void deleteById(Long id);

    ReportingLineTypeResponse toDTO(ReportingLineType reportingLineType);
}
