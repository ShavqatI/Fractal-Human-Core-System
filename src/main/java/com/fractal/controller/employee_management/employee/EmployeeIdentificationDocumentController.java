package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.identification_document.IdentificationDocumentService;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/identification-document")
@RequiredArgsConstructor
public class EmployeeIdentificationDocumentController {

    private final IdentificationDocumentService identificationDocumentService;

    @PostMapping()
    public ResponseEntity<IdentificationDocumentResponse> create(@PathVariable Long employeeId, @RequestBody @Valid IdentificationDocumentRequest dto) {
        return new ResponseEntity<>(identificationDocumentService.toDTO(identificationDocumentService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<IdentificationDocumentResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(identificationDocumentService.getAllByEmployeeId(employeeId).stream().map(identificationDocumentService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<IdentificationDocumentResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(identificationDocumentService.toDTO(identificationDocumentService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<IdentificationDocumentResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid IdentificationDocumentRequest dto) {
        return ResponseEntity.ok(identificationDocumentService.toDTO(identificationDocumentService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        identificationDocumentService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }



}
