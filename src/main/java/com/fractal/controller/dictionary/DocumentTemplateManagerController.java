package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerResponse;
import com.fractal.domain.dictionary.gender.dto.GenderRequest;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/document-template-manager")
@RequiredArgsConstructor
public class DocumentTemplateManagerController {

    private final DocumentTemplateManagerService documentTemplateManagerService;
    @PostMapping
    public ResponseEntity<DocumentTemplateManagerResponse> create(@RequestBody @Valid DocumentTemplateManagerRequest dto) {
        return new ResponseEntity<>(documentTemplateManagerService.toDTO(documentTemplateManagerService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DocumentTemplateManagerResponse>> getAll() {
        return ResponseEntity.ok(documentTemplateManagerService.getAll().stream().map(documentTemplateManagerService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DocumentTemplateManagerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(documentTemplateManagerService.toDTO(documentTemplateManagerService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<DocumentTemplateManagerResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(documentTemplateManagerService.toDTO(documentTemplateManagerService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DocumentTemplateManagerResponse> update(@PathVariable Long id, @RequestBody @Valid DocumentTemplateManagerRequest dto) {
      return  ResponseEntity.ok(documentTemplateManagerService.toDTO(documentTemplateManagerService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        documentTemplateManagerService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
