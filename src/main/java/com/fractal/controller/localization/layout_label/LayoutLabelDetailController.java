package com.fractal.controller.localization.layout_label;


import com.fractal.domain.localization.layout_label.detail.LayoutLabelDetailService;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailRequest;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/localization/layout-label/{layoutLabelId}/detail")
@RequiredArgsConstructor
public class LayoutLabelDetailController {

    private final LayoutLabelDetailService layoutLabelDetailService;

    @PostMapping()
    public ResponseEntity<LayoutLabelDetailResponse> create(@PathVariable Long layoutLabelId, @RequestBody @Valid LayoutLabelDetailRequest dto) {
        return new ResponseEntity<>(layoutLabelDetailService.toDTO(layoutLabelDetailService.create(layoutLabelId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LayoutLabelDetailResponse>> getAll(@PathVariable Long layoutLabelId) {
        return ResponseEntity.ok(layoutLabelDetailService.getAllByLayoutLabelId(layoutLabelId).stream().map(layoutLabelDetailService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LayoutLabelDetailResponse> getById(@PathVariable Long layoutLabelId, @PathVariable Long id) {
        return ResponseEntity.ok(layoutLabelDetailService.toDTO(layoutLabelDetailService.getById(layoutLabelId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LayoutLabelDetailResponse> update(@PathVariable Long layoutLabelId, @PathVariable Long id, @RequestBody @Valid LayoutLabelDetailRequest dto) {
        return ResponseEntity.ok(layoutLabelDetailService.toDTO(layoutLabelDetailService.update(layoutLabelId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long layoutLabelId, @PathVariable Long id) {
        layoutLabelDetailService.delete(layoutLabelId, id);
        return ResponseEntity.noContent().build();
    }

}
