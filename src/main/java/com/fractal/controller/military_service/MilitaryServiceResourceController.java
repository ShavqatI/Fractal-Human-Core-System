package com.fractal.controller.military_service;

import com.fractal.domain.military_service.resource.MilitaryServiceResourceService;
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
@RequestMapping("/api/v1/military-service/{militaryServiceId}/resource")
@RequiredArgsConstructor
public class MilitaryServiceResourceController {

    private final MilitaryServiceResourceService resourceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> create(@PathVariable Long militaryServiceId,  @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(militaryServiceId,file)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll(@PathVariable Long militaryServiceId) {
        return ResponseEntity.ok(resourceService.getAllByMilitaryServiceId(militaryServiceId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable Long militaryServiceId,@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(militaryServiceId,id)));
    }
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResourceResponse> update(@PathVariable Long militaryServiceId, @PathVariable Long id,  @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(militaryServiceId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long militaryServiceId, @PathVariable Long id) {
        resourceService.delete(militaryServiceId,id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long militaryServiceId, @PathVariable Long id) {
        var militaryServiceResource = resourceService.getById(militaryServiceId, id);
        try {
            Path filePath = Path.of(militaryServiceResource.getUrl()).toAbsolutePath();
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
