package com.fractal.controller.localization;


import com.fractal.domain.localization.language.LanguageService;
import com.fractal.domain.localization.language.dto.LanguageRequest;
import com.fractal.domain.localization.language.dto.LanguageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/localization/language")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;
    @PostMapping
    public ResponseEntity<LanguageResponse> create(@RequestBody @Valid LanguageRequest dto) {
        return new ResponseEntity<>(languageService.toDTO(languageService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<LanguageResponse>> getAll() {
        return ResponseEntity.ok(languageService.getAll().stream().map(languageService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(languageService.toDTO(languageService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<LanguageResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(languageService.toDTO(languageService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LanguageResponse> update(@PathVariable Long id, @RequestBody @Valid LanguageRequest dto) {
      return  ResponseEntity.ok(languageService.toDTO(languageService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        languageService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
