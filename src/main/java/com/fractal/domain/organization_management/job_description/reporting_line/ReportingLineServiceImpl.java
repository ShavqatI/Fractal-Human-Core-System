package com.fractal.domain.organization_management.job_description.reporting_line;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineResponse;
import com.fractal.domain.organization_management.job_description.reporting_line.mapper.ReportingLineMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ReportingLineServiceImpl implements ReportingLineService {

    private final ReportingLineRepository reportingLineRepository;
    private final ReportingLineMapperService mapperService;
    private final JobDescriptionService jobDescriptionService;

    @Override
    @Transactional
    public ReportingLine create(Long jobDescriptionId, ReportingLineRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var reportingLine = mapperService.toEntity(dto);
        jobDescription.addReportingLine(reportingLine);
        jobDescriptionService.save(jobDescription);
        return reportingLine;
    }

    @Override
    public List<ReportingLine> getAllByJobDescriptionId(Long jobDescriptionId) {
        return reportingLineRepository.findAllByJobDescriptionId(jobDescriptionId);
    }

    @Override
    public ReportingLine getById(Long jobDescriptionId, Long id) {
        return reportingLineRepository.findByJobDescriptionIdAndId(jobDescriptionId, id).orElseThrow(() -> new ResourceNotFoundException("ReportingLine with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public ReportingLine update(Long jobDescriptionId, Long id, ReportingLineRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        ReportingLine reportingLine = jobDescription.getReportingLines().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Reporting Line with id: " + id + " not found"));
        reportingLine = reportingLineRepository.save(mapperService.toEntity(reportingLine, dto));
        jobDescriptionService.save(jobDescription);
        return reportingLine;
    }

    @Override
    @Transactional
    public void delete(Long jobDescriptionId, Long id) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        ReportingLine reportingLine = jobDescription.getReportingLines().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("ReportingLine with id: " + id + " not found"));
        jobDescription.removeReportingLine(reportingLine);
        jobDescriptionService.save(jobDescription);

    }

    @Override
    public ReportingLineResponse toDTO(ReportingLine reportingLine) {
        return mapperService.toDTO(reportingLine);
    }

}
