package com.fractal.controller.employee_management.employee.education;


import com.fractal.domain.employee_management.education.document_type.EducationDocumentTypeService;
import com.fractal.domain.employee_management.education.document_type.dto.EducationDocumentTypeRequest;
import com.fractal.domain.employee_management.education.document_type.dto.EducationDocumentTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/education/document-type")
@RequiredArgsConstructor
public class EducationDocumentTypeController {

    private final EducationDocumentTypeService educationDocumentTypeService;
    @PostMapping
    public ResponseEntity<EducationDocumentTypeResponse> create(@RequestBody @Valid EducationDocumentTypeRequest dto) {
        return new ResponseEntity<>(educationDocumentTypeService.toDTO(educationDocumentTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EducationDocumentTypeResponse>> getAll() {
        return ResponseEntity.ok(educationDocumentTypeService.getAll().stream().map(educationDocumentTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EducationDocumentTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(educationDocumentTypeService.toDTO(educationDocumentTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<EducationDocumentTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(educationDocumentTypeService.toDTO(educationDocumentTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EducationDocumentTypeResponse> update(@PathVariable Long id, @RequestBody @Valid EducationDocumentTypeRequest dto) {
      return  ResponseEntity.ok(educationDocumentTypeService.toDTO(educationDocumentTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        educationDocumentTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
