package com.fractal.controller.employee_management.business_trip;


import com.fractal.domain.employee_management.business_trip.resource.BusinessTripResourceService;
import com.fractal.domain.resource.dto.ResourceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/{businessTripId}/resource")
@RequiredArgsConstructor
public class BusinessTripResourceController {

    private final BusinessTripResourceService resourceService;

    @PostMapping()
    public ResponseEntity<ResourceResponse> create(@PathVariable Long businessTripId, @RequestBody @Valid MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(businessTripId,file)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long businessTripId) {
        return ResponseEntity.ok(resourceService.getAllByBusinessTripId(businessTripId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long businessTripId,@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(businessTripId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResourceResponse> update(@PathVariable Long businessTripId, @PathVariable Long id, @RequestBody @Valid MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(businessTripId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long businessTripId, @PathVariable Long id) {
        resourceService.delete(businessTripId,id);
        return ResponseEntity.noContent().build();
    }



}
