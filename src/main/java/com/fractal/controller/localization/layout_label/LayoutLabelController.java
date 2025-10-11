package com.fractal.controller.localization.layout_label;


import com.fractal.domain.localization.language.dto.LanguageResponse;
import com.fractal.domain.localization.layout_label.LayoutLabel;
import com.fractal.domain.localization.layout_label.LayoutLabelService;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelListRequest;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelRequest;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/localization/layout-label")
@RequiredArgsConstructor
public class LayoutLabelController {

    private final LayoutLabelService layoutLabelService;
    @PostMapping
    public ResponseEntity<LayoutLabelResponse> create(@RequestBody @Valid LayoutLabelRequest dto) {
        return new ResponseEntity<>(layoutLabelService.toDTO(layoutLabelService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<LayoutLabelResponse>> getAll() {
        return ResponseEntity.ok(layoutLabelService.getAll().stream().map(layoutLabelService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/list")
    public ResponseEntity<List<LayoutLabelResponse>> getAllByListAndLanguage(@RequestBody LayoutLabelListRequest dto) {
        return ResponseEntity.ok(layoutLabelService.getAllByListAndLanguageCode(dto).stream().map(layoutLabelService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LayoutLabelResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(layoutLabelService.toDTO(layoutLabelService.getById(id)));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<LayoutLabelResponse> getByName(@PathVariable String name) {
        return ResponseEntity.ok(layoutLabelService.toDTO(layoutLabelService.getByName(name)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LayoutLabelResponse> update(@PathVariable Long id, @RequestBody @Valid LayoutLabelRequest dto) {
      return  ResponseEntity.ok(layoutLabelService.toDTO(layoutLabelService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        layoutLabelService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
