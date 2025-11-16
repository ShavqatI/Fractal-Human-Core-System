package com.fractal.domain.organization_management.job_description.reporting_line.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.job_description.reporting_line.ReportingLine;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineResponse;
import com.fractal.domain.organization_management.job_description.reporting_line.type.ReportingLineTypeService;
import com.fractal.domain.organization_management.position.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ReportingLineMapperServiceImpl implements ReportingLineMapperService {

    private final ReportingLineTypeService typeService;
    private final PositionService positionService;
    private final StatusService statusService;

    @Override
    public ReportingLineResponse toDTO(ReportingLine reportingLine) {
        return new ReportingLineResponse(
                reportingLine.getId(),
                typeService.toDTO(reportingLine.getReportingLineType()),
                positionService.toCompactDTO(reportingLine.getPosition()),
                statusService.toCompactDTO(reportingLine.getStatus()),
                reportingLine.getCreatedDate()
        );
    }

    @Override
    public ReportingLine toEntity(ReportingLineRequest dto) {
        return mapToEntity(new ReportingLine(), dto);
    }

    @Override
    public ReportingLine toEntity(ReportingLine reportingLine, ReportingLineRequest dto) {
        return mapToEntity(reportingLine, dto);
    }

    private ReportingLine mapToEntity(ReportingLine reportingLine, ReportingLineRequest dto) {
        reportingLine.setPosition(positionService.getById(dto.positionId()));
        reportingLine.setReportingLineType(typeService.getById(dto.reportingTypeId()));
        reportingLine.setStatus(statusService.getById(dto.statusId()));
        return reportingLine;
    }
}
