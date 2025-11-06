package com.fractal.controller.learning_develpment.learning.session;

import com.fractal.domain.learning_develpment.learning.session.resource.LearningSessionResourceService;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;
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
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/resource")
@RequiredArgsConstructor
public class LearningSessionResourceController {

    private final LearningSessionResourceService resourceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LearningSessionResourceResponse> create(@PathVariable Long sessionId, @ModelAttribute @Valid LearningSessionResourceRequest dto) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(sessionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<LearningSessionResourceResponse>> getAll(@PathVariable Long sessionId) {
        return ResponseEntity.ok(resourceService.getAllByLearningSessionId(sessionId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LearningSessionResourceResponse> getById(@PathVariable Long sessionId, @PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(sessionId,id)));
    }
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LearningSessionResourceResponse> update(@PathVariable Long sessionId, @PathVariable Long id, @ModelAttribute @Valid LearningSessionResourceRequest dto) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(sessionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sessionId, @PathVariable Long id) {
        resourceService.delete(sessionId,id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long sessionId, @PathVariable Long id) {
        var sessionResource = resourceService.getById(sessionId,id);
        try {
            Path filePath = Path.of(sessionResource.getUrl()).toAbsolutePath();
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
