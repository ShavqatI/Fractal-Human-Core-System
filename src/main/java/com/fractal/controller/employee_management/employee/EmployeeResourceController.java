package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.employee.resource.EmployeeResourceService;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceRequest;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/resource")
@RequiredArgsConstructor
public class EmployeeResourceController {

    private final EmployeeResourceService resourceService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EmployeeResourceResponse> create(@PathVariable Long employeeId,@ModelAttribute @Valid EmployeeResourceRequest dto) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResourceResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(resourceService.getAllByEmployeeId(employeeId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResourceResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResourceResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EmployeeResourceRequest dto) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        resourceService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }



}
