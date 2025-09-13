package com.fractal.controller.education;


import com.fractal.domain.education.language_skill.proficiency.LanguageProficiencyService;
import com.fractal.domain.education.language_skill.proficiency.dto.LanguageProficiencyRequest;
import com.fractal.domain.education.language_skill.proficiency.dto.LanguageProficiencyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/education/Language-proficiency")
@RequiredArgsConstructor
public class LanguageProficiencyController {

    private final LanguageProficiencyService languageProficiencyService;
    @PostMapping
    public ResponseEntity<LanguageProficiencyResponse> create(@RequestBody @Valid LanguageProficiencyRequest dto) {
        return new ResponseEntity<>(languageProficiencyService.toDTO(languageProficiencyService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<LanguageProficiencyResponse>> getAll() {
        return ResponseEntity.ok(languageProficiencyService.getAll().stream().map(languageProficiencyService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LanguageProficiencyResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(languageProficiencyService.toDTO(languageProficiencyService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<LanguageProficiencyResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(languageProficiencyService.toDTO(languageProficiencyService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LanguageProficiencyResponse> update(@PathVariable Long id, @RequestBody @Valid LanguageProficiencyRequest dto) {
      return  ResponseEntity.ok(languageProficiencyService.toDTO(languageProficiencyService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        languageProficiencyService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
