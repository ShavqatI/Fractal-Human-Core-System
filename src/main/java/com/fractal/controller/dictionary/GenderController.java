package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.gender.GenderService;
import com.fractal.domain.dictionary.gender.dto.GenderRequest;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/gender")
@RequiredArgsConstructor
public class GenderController {

    private final GenderService genderService;
    @PostMapping
    public ResponseEntity<GenderResponse> create(@RequestBody @Valid GenderRequest dto) {
        return new ResponseEntity<>(genderService.toDTO(genderService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GenderResponse>> getAll() {
        return ResponseEntity.ok(genderService.getAll().stream().map(genderService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(genderService.toDTO(genderService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<GenderResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(genderService.toDTO(genderService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenderResponse> update(@PathVariable Long id, @RequestBody @Valid GenderRequest dto) {
      return  ResponseEntity.ok(genderService.toDTO(genderService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        genderService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
