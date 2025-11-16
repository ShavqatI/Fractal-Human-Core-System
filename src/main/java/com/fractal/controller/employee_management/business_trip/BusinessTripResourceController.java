package com.fractal.controller.employee_management.business_trip;


import com.fractal.domain.employee_management.business_trip.resource.BusinessTripResourceService;
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
@RequestMapping("/api/v1/employee-management/business-trip/{businessTripId}/resource")
@RequiredArgsConstructor
public class BusinessTripResourceController {

    private final BusinessTripResourceService resourceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> create(@PathVariable Long businessTripId, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(businessTripId, file)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long businessTripId) {
        return ResponseEntity.ok(resourceService.getAllByBusinessTripId(businessTripId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long businessTripId, @PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(businessTripId, id)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> update(@PathVariable Long businessTripId, @PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(businessTripId, id, file)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long businessTripId, @PathVariable Long id) {
        resourceService.delete(businessTripId, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long agreementId, @PathVariable Long id) {
        var businessTripResource = resourceService.getById(agreementId, id);
        try {
            Path filePath = Path.of(businessTripResource.getUrl()).toAbsolutePath();
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
