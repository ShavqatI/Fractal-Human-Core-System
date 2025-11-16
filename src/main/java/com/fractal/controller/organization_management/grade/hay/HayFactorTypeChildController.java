package com.fractal.controller.organization_management.grade.hay;

import com.fractal.domain.organization_management.grade.method.hay.factor.type.HayFactorTypeService;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organization-management/grade-management/hay/factor/type/{factorTypeId}/child")
@RequiredArgsConstructor
public class HayFactorTypeChildController {

    private final HayFactorTypeService factorTypeService;

    @PostMapping()
    public ResponseEntity<HayFactorTypeResponse> create(@PathVariable Long factorTypeId, @RequestBody @Valid HayFactorTypeRequest dto) {
        return new ResponseEntity<>(factorTypeService.toDTO(factorTypeService.addChild(factorTypeId, dto)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HayFactorTypeResponse> update(@PathVariable Long factorTypeId, @PathVariable Long id, @RequestBody @Valid HayFactorTypeRequest dto) {
        return ResponseEntity.ok(factorTypeService.toDTO(factorTypeService.updateChild(factorTypeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long factorTypeId, @PathVariable Long id) {
        factorTypeService.deleteChild(factorTypeId, id);
        return ResponseEntity.noContent().build();
    }
}
