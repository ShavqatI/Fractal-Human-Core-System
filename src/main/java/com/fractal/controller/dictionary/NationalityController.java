package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.nationality.NationalityService;
import com.fractal.domain.dictionary.nationality.dto.NationalityRequest;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/nationality")
@RequiredArgsConstructor
public class NationalityController {

    private final NationalityService nationalityService;
    @PostMapping
    public ResponseEntity<NationalityResponse> create(@RequestBody @Valid NationalityRequest dto) {
        return new ResponseEntity<>(nationalityService.toDTO(nationalityService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<NationalityResponse>> getAll() {
        return ResponseEntity.ok(nationalityService.getAll().stream().map(nationalityService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<NationalityResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(nationalityService.toDTO(nationalityService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<NationalityResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(nationalityService.toDTO(nationalityService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<NationalityResponse> update(@PathVariable Long id, @RequestBody @Valid NationalityRequest dto) {
      return  ResponseEntity.ok(nationalityService.toDTO(nationalityService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        nationalityService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
