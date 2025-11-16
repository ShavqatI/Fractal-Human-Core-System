package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.location.online.OnlineLearningLocationService;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/location/online")
@RequiredArgsConstructor
public class OnlineLearningLocationController {

    private final OnlineLearningLocationService locationService;

    @PostMapping()
    public ResponseEntity<OnlineLearningLocationResponse> create(@PathVariable Long sessionId, @RequestBody @Valid OnlineLearningLocationRequest dto) {
        return new ResponseEntity<>(locationService.toDTO(locationService.create(sessionId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OnlineLearningLocationResponse>> getAll(@PathVariable Long sessionId) {
        return ResponseEntity.ok(locationService.getAllByLearningSessionId(sessionId).stream().map(locationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnlineLearningLocationResponse> getById(@PathVariable Long sessionId, @PathVariable Long id) {
        return ResponseEntity.ok(locationService.toDTO(locationService.getById(sessionId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlineLearningLocationResponse> update(@PathVariable Long sessionId, @PathVariable Long id, @RequestBody @Valid OnlineLearningLocationRequest dto) {
        return ResponseEntity.ok(locationService.toDTO(locationService.update(sessionId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sessionId, @PathVariable Long id) {
        locationService.delete(sessionId, id);
        return ResponseEntity.noContent().build();
    }


}
