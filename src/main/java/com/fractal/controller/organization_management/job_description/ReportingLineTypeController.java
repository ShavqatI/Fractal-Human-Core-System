package com.fractal.controller.organization_management.job_description;


import com.fractal.domain.organization_management.job_description.reporting_line.type.ReportingLineTypeService;
import com.fractal.domain.organization_management.job_description.reporting_line.type.dto.ReportingLineTypeRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.type.dto.ReportingLineTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/reporting-line-type")
@RequiredArgsConstructor
public class ReportingLineTypeController {

    private final ReportingLineTypeService reportingLineTypeService;
    @PostMapping
    public ResponseEntity<ReportingLineTypeResponse> create(@RequestBody @Valid ReportingLineTypeRequest dto) {
        return new ResponseEntity<>(reportingLineTypeService.toDTO(reportingLineTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ReportingLineTypeResponse>> getAll() {
        return ResponseEntity.ok(reportingLineTypeService.getAll().stream().map(reportingLineTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReportingLineTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(reportingLineTypeService.toDTO(reportingLineTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<ReportingLineTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(reportingLineTypeService.toDTO(reportingLineTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReportingLineTypeResponse> update(@PathVariable Long id, @RequestBody @Valid ReportingLineTypeRequest dto) {
      return  ResponseEntity.ok(reportingLineTypeService.toDTO(reportingLineTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reportingLineTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
