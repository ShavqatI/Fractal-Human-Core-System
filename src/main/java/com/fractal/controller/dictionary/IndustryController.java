package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.industry.IndustryService;
import com.fractal.domain.dictionary.industry.dto.IndustryRequest;
import com.fractal.domain.dictionary.industry.dto.IndustryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/industry")
@RequiredArgsConstructor
public class IndustryController {

    private final IndustryService industryService;
    @PostMapping
    public ResponseEntity<IndustryResponse> create(@RequestBody @Valid IndustryRequest dto) {
        return new ResponseEntity<>(industryService.toDTO(industryService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<IndustryResponse>> getAll() {
        return ResponseEntity.ok(industryService.getAll().stream().map(industryService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<IndustryResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(industryService.toDTO(industryService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<IndustryResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(industryService.toDTO(industryService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<IndustryResponse> update(@PathVariable Long id, @RequestBody @Valid IndustryRequest dto) {
      return  ResponseEntity.ok(industryService.toDTO(industryService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        industryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
