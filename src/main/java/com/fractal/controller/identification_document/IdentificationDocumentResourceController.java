package com.fractal.controller.identification_document;


import com.fractal.domain.identification_document.resource.IdentificationDocumentResourceService;
import com.fractal.domain.resource.dto.ResourceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/identification-document/{identificationDocumentId}/resource")
@RequiredArgsConstructor
public class IdentificationDocumentResourceController {

    private final IdentificationDocumentResourceService resourceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> create(@PathVariable Long identificationDocumentId, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(identificationDocumentId,file)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long identificationDocumentId) {
        return ResponseEntity.ok(resourceService.getAllByIdentificationDocumentId(identificationDocumentId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long identificationDocumentId,@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(identificationDocumentId,id)));
    }
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> update(@PathVariable Long identificationDocumentId, @PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(identificationDocumentId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long identificationDocumentId, @PathVariable Long id) {
        resourceService.delete(identificationDocumentId,id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long identificationDocumentId, @PathVariable Long id) {
        var identificationDocumentResource = resourceService.getById(identificationDocumentId, id);
        try {
            Path filePath = Path.of(identificationDocumentResource.getUrl()).toAbsolutePath();
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
