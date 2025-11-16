package com.fractal.controller.employment;

import com.fractal.domain.employment.separation_reason_type.SeparationReasonTypeService;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeRequest;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employment/separation-reason-type/{separationReasonTypeId}/child")
@RequiredArgsConstructor
public class SeparationReasonTypeChildController {

    private final SeparationReasonTypeService separationReasonTypeService;

    @PostMapping()
    public ResponseEntity<SeparationReasonTypeResponse> create(@PathVariable Long separationReasonTypeId, @RequestBody @Valid SeparationReasonTypeRequest dto) {
        return new ResponseEntity<>(separationReasonTypeService.toDTO(separationReasonTypeService.addChild(separationReasonTypeId, dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeparationReasonTypeResponse> update(@PathVariable Long separationReasonTypeId, @PathVariable Long id, @RequestBody @Valid SeparationReasonTypeRequest dto) {
        return ResponseEntity.ok(separationReasonTypeService.toDTO(separationReasonTypeService.updateChild(separationReasonTypeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long separationReasonTypeId, @PathVariable Long id) {
        separationReasonTypeService.deleteChild(separationReasonTypeId, id);
        return ResponseEntity.noContent().build();
    }
}
