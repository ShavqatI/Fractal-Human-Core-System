package com.fractal.controller.learning_develpment.learning;


import com.fractal.domain.learning_develpment.learning.delivery_mode.LearningDeliveryModeService;
import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeRequest;
import com.fractal.domain.learning_develpment.learning.delivery_mode.dto.LearningDeliveryModeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/delivery-mode")
@RequiredArgsConstructor
public class LearningDeliveryModeController {

    private final LearningDeliveryModeService deliveryModeService;

    @PostMapping
    public ResponseEntity<LearningDeliveryModeResponse> create(@RequestBody @Valid LearningDeliveryModeRequest dto) {
        return new ResponseEntity<>(deliveryModeService.toDTO(deliveryModeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningDeliveryModeResponse>> getAll() {
        return ResponseEntity.ok(deliveryModeService.getAll().stream().map(deliveryModeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningDeliveryModeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryModeService.toDTO(deliveryModeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<LearningDeliveryModeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(deliveryModeService.toDTO(deliveryModeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningDeliveryModeResponse> update(@PathVariable Long id, @RequestBody @Valid LearningDeliveryModeRequest dto) {
        return ResponseEntity.ok(deliveryModeService.toDTO(deliveryModeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deliveryModeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
