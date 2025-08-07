package com.fractal.controller.navigation.action;

import com.fractal.domain.navigation.action.ActionService;
import com.fractal.domain.navigation.action.dto.ActionCompactResponse;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/navigation/action")
@RequiredArgsConstructor
public class ActionController {

    private final ActionService actionService;

    @PostMapping
    public ResponseEntity<ActionResponse> create(@RequestBody @Valid ActionRequest dto) {
        return new ResponseEntity<>(actionService.toDTO(actionService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActionResponse>> getAll() {
        return ResponseEntity.ok(actionService.getAll().stream().map(actionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<ActionCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(actionService.getAll().stream().map(actionService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(actionService.toDTO(actionService.getById(id)));
    }
    @GetMapping("/url{url}")
    public ResponseEntity<ActionResponse> getById(@PathVariable String url) {
        return ResponseEntity.ok(actionService.toDTO(actionService.getByUrl(url)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ActionResponse> update(@PathVariable Long id, @RequestBody @Valid ActionRequest dto) {
        return ResponseEntity.ok(actionService.toDTO(actionService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
