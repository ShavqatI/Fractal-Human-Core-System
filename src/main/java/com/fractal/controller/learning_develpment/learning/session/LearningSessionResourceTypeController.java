package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.resource.type.LearningSessionResourceTypeService;
import com.fractal.domain.learning_develpment.learning.session.resource.type.dto.LearningSessionResourceTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.type.dto.LearningSessionResourceTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/resource-type")
@RequiredArgsConstructor
public class LearningSessionResourceTypeController {

    private final LearningSessionResourceTypeService resourceTypeService;

    @PostMapping
    public ResponseEntity<LearningSessionResourceTypeResponse> create(@RequestBody @Valid LearningSessionResourceTypeRequest dto) {
        return new ResponseEntity<>(resourceTypeService.toDTO(resourceTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningSessionResourceTypeResponse>> getAll() {
        return ResponseEntity.ok(resourceTypeService.getAll().stream().map(resourceTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningSessionResourceTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<LearningSessionResourceTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningSessionResourceTypeResponse> update(@PathVariable Long id, @RequestBody @Valid LearningSessionResourceTypeRequest dto) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        resourceTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
