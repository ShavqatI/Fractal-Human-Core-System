package com.fractal.controller.agreement;


import com.fractal.domain.agreement.resource.AgreementResourceService;
import com.fractal.domain.resource.dto.ResourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/agreement/{agreementId}/resource")
@RequiredArgsConstructor
public class AgreementResourceController {

    private final AgreementResourceService resourceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> create(@PathVariable Long agreementId, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(agreementId,file)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long agreementId) {
        return ResponseEntity.ok(resourceService.getAllByAgreementId(agreementId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long agreementId, @PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(agreementId,id)));
    }
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> update(@PathVariable Long agreementId, @PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(agreementId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long agreementId, @PathVariable Long id) {
        resourceService.delete(agreementId,id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long agreementId, @PathVariable Long id) {
        var agreementResource = resourceService.getById(agreementId, id);
        try {
            Path filePath = Path.of(agreementResource.getUrl()).toAbsolutePath();
            Resource resource = new FileSystemResource(filePath);
            String encodedFilename = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8);
            if (!resource.exists()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFilename + "\"")
                    .body(resource);


        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



}
