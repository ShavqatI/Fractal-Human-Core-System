package com.fractal.controller.navigation.action;


import com.fractal.domain.navigation.action.type.ActionTypeService;
import com.fractal.domain.navigation.action.type.dto.ActionTypeRequest;
import com.fractal.domain.navigation.action.type.dto.ActionTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/navigation/action/type")
@RequiredArgsConstructor
public class ActionTypeController {

    private final ActionTypeService actionTypeService;

    @PostMapping
    public ResponseEntity<ActionTypeResponse> create(@RequestBody @Valid ActionTypeRequest dto) {
        return new ResponseEntity<>(actionTypeService.toDTO(actionTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActionTypeResponse>> getAll() {
        return ResponseEntity.ok(actionTypeService.getAll().stream().map(actionTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(actionTypeService.toDTO(actionTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ActionTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(actionTypeService.toDTO(actionTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActionTypeResponse> update(@PathVariable Long id, @RequestBody @Valid ActionTypeRequest dto) {
        return ResponseEntity.ok(actionTypeService.toDTO(actionTypeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actionTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
