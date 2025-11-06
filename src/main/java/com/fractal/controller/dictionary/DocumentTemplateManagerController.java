package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerRequest;
import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerResponse;
import com.fractal.domain.dictionary.gender.dto.GenderRequest;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/document-template-manager")
@RequiredArgsConstructor
public class DocumentTemplateManagerController {

    private final DocumentTemplateManagerService documentTemplateManagerService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DocumentTemplateManagerResponse> create(@ModelAttribute @Valid DocumentTemplateManagerRequest dto) {
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
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DocumentTemplateManagerResponse> update(@PathVariable Long id, @ModelAttribute @Valid DocumentTemplateManagerRequest dto) {
      return  ResponseEntity.ok(documentTemplateManagerService.toDTO(documentTemplateManagerService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        documentTemplateManagerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id) {
        var documentTemplateManager = documentTemplateManagerService.getById(id);
        try {
            Path filePath = Path.of(documentTemplateManager.getFilePath()).toAbsolutePath();
            Resource resource = new FileSystemResource(filePath);
            if (!resource.exists()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);


        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
