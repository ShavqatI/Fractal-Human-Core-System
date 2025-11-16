package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.location.type.LearningLocationTypeService;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/location-type")
@RequiredArgsConstructor
public class LearningLocationTypeController {

    private final LearningLocationTypeService locationTypeService;

    @PostMapping
    public ResponseEntity<LearningLocationTypeResponse> create(@RequestBody @Valid LearningLocationTypeRequest dto) {
        return new ResponseEntity<>(locationTypeService.toDTO(locationTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningLocationTypeResponse>> getAll() {
        return ResponseEntity.ok(locationTypeService.getAll().stream().map(locationTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningLocationTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(locationTypeService.toDTO(locationTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<LearningLocationTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(locationTypeService.toDTO(locationTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningLocationTypeResponse> update(@PathVariable Long id, @RequestBody @Valid LearningLocationTypeRequest dto) {
        return ResponseEntity.ok(locationTypeService.toDTO(locationTypeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
