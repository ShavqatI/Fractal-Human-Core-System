package com.fractal.controller.employee_management.employee.identification_document;


import com.fractal.domain.identification_document.type.IdentificationDocumentTypeService;
import com.fractal.domain.identification_document.type.dto.IdentificationDocumentTypeRequest;
import com.fractal.domain.identification_document.type.dto.IdentificationDocumentTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/identification-document/type")
@RequiredArgsConstructor
public class IdentificationDocumentTypeController {

    private final IdentificationDocumentTypeService identificationDocumentTypeService;
    @PostMapping
    public ResponseEntity<IdentificationDocumentTypeResponse> create(@RequestBody @Valid IdentificationDocumentTypeRequest dto) {
        return new ResponseEntity<>(identificationDocumentTypeService.toDTO(identificationDocumentTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<IdentificationDocumentTypeResponse>> getAll() {
        return ResponseEntity.ok(identificationDocumentTypeService.getAll().stream().map(identificationDocumentTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<IdentificationDocumentTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(identificationDocumentTypeService.toDTO(identificationDocumentTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<IdentificationDocumentTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(identificationDocumentTypeService.toDTO(identificationDocumentTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<IdentificationDocumentTypeResponse> update(@PathVariable Long id, @RequestBody @Valid IdentificationDocumentTypeRequest dto) {
      return  ResponseEntity.ok(identificationDocumentTypeService.toDTO(identificationDocumentTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        identificationDocumentTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
