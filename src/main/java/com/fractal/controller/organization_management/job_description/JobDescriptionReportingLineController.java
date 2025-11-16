package com.fractal.controller.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.reporting_line.ReportingLineService;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/job-description/{jobDescriptionId}/reporting-line")
@RequiredArgsConstructor
public class JobDescriptionReportingLineController {

    private final ReportingLineService reportingLineService;

    @PostMapping()
    public ResponseEntity<ReportingLineResponse> create(@PathVariable Long jobDescriptionId, @RequestBody @Valid ReportingLineRequest dto) {
        return new ResponseEntity<>(reportingLineService.toDTO(reportingLineService.create(jobDescriptionId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReportingLineResponse>> getAll(@PathVariable Long jobDescriptionId) {
        return ResponseEntity.ok(reportingLineService.getAllByJobDescriptionId(jobDescriptionId).stream().map(reportingLineService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportingLineResponse> getById(@PathVariable Long jobDescriptionId, @PathVariable Long id) {
        return ResponseEntity.ok(reportingLineService.toDTO(reportingLineService.getById(jobDescriptionId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportingLineResponse> update(@PathVariable Long jobDescriptionId, @PathVariable Long id, @RequestBody @Valid ReportingLineRequest dto) {
        return ResponseEntity.ok(reportingLineService.toDTO(reportingLineService.update(jobDescriptionId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long jobDescriptionId, @PathVariable Long id) {
        reportingLineService.delete(jobDescriptionId, id);
        return ResponseEntity.noContent().build();
    }

}
