package com.fractal.controller.dictionary.status;


import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.dictionary.status.dto.StatusRequest;
import com.fractal.domain.dictionary.status.dto.StatusResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/status")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;
    @PostMapping
    public ResponseEntity<StatusResponse> create(@RequestBody @Valid StatusRequest dto) {
        return new ResponseEntity<>(statusService.toDTO(statusService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<StatusResponse>> getAll() {
        return ResponseEntity.ok(statusService.getAll().stream().map(statusService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StatusResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(statusService.toDTO(statusService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<StatusResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(statusService.toDTO(statusService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StatusResponse> update(@PathVariable Long id, @RequestBody @Valid StatusRequest dto) {
      return  ResponseEntity.ok(statusService.toDTO(statusService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        statusService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
