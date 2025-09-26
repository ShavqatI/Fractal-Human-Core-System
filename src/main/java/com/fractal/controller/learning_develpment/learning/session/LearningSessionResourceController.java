package com.fractal.controller.learning_develpment.learning.session;

import com.fractal.domain.learning_develpment.learning.session.resource.LearningSessionResourceService;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/resource")
@RequiredArgsConstructor
public class LearningSessionResourceController {

    private final LearningSessionResourceService resourceService;

    @PostMapping()
    public ResponseEntity<LearningSessionResourceResponse> create(@PathVariable Long sessionId, @RequestBody @Valid LearningSessionResourceRequest dto) {
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
    @PutMapping("/{id}")
    public ResponseEntity<LearningSessionResourceResponse> update(@PathVariable Long sessionId, @PathVariable Long id, @RequestBody @Valid LearningSessionResourceRequest dto) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(sessionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sessionId, @PathVariable Long id) {
        resourceService.delete(sessionId,id);
        return ResponseEntity.noContent().build();
    }



}
