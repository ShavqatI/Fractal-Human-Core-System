package com.fractal.controller.organization_management.organization;

import com.fractal.domain.organization_management.organization.work_schedule.OrganizationWorkScheduleService;
import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/organization/{organizationId}/work-schedule")
@RequiredArgsConstructor
public class OrganizationWorkScheduleController {

    private final OrganizationWorkScheduleService workScheduleService;

    @PostMapping()
    public ResponseEntity<WorkScheduleResponse> create(@PathVariable Long organizationId, @RequestBody @Valid WorkScheduleRequest dto) {
        return new ResponseEntity<>(workScheduleService.toDTO(workScheduleService.create(organizationId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WorkScheduleResponse>> getAll(@PathVariable Long organizationId) {
        return ResponseEntity.ok(workScheduleService.getAllByOrganizationId(organizationId).stream().map(workScheduleService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkScheduleResponse> getById(@PathVariable Long organizationId,@PathVariable Long id) {
        return ResponseEntity.ok(workScheduleService.toDTO(workScheduleService.getById(organizationId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<WorkScheduleResponse> update(@PathVariable Long organizationId, @PathVariable Long id, @RequestBody @Valid WorkScheduleRequest dto) {
        return ResponseEntity.ok(workScheduleService.toDTO(workScheduleService.update(organizationId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long organizationId, @PathVariable Long id) {
        workScheduleService.delete(organizationId,id);
        return ResponseEntity.noContent().build();
    }

}
