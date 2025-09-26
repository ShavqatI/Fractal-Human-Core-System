package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocationService;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/location/offline")
@RequiredArgsConstructor
public class OfflineLearningLocationController {

    private final OfflineLearningLocationService locationService;

    @PostMapping()
    public ResponseEntity<OfflineLearningLocationResponse> create(@PathVariable Long sessionId, @RequestBody @Valid OfflineLearningLocationRequest dto) {
        return new ResponseEntity<>(locationService.toDTO(locationService.create(sessionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<OfflineLearningLocationResponse>> getAll(@PathVariable Long sessionId) {
        return ResponseEntity.ok(locationService.getAllByLearningSessionId(sessionId).stream().map(locationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OfflineLearningLocationResponse> getById(@PathVariable Long sessionId, @PathVariable Long id) {
        return ResponseEntity.ok(locationService.toDTO(locationService.getById(sessionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfflineLearningLocationResponse> update(@PathVariable Long sessionId, @PathVariable Long id, @RequestBody @Valid OfflineLearningLocationRequest dto) {
        return ResponseEntity.ok(locationService.toDTO(locationService.update(sessionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sessionId, @PathVariable Long id) {
        locationService.delete(sessionId,id);
        return ResponseEntity.noContent().build();
    }


}
