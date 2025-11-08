package com.fractal.controller.agreement;


import com.fractal.domain.agreement.type.AgreementTypeService;
import com.fractal.domain.agreement.type.dto.AgreementTypeRequest;
import com.fractal.domain.agreement.type.dto.AgreementTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/agreement/type")
@RequiredArgsConstructor
public class AgreementTypeController {

    private final AgreementTypeService agreementTypeService;
    @PostMapping
    public ResponseEntity<AgreementTypeResponse> create(@RequestBody @Valid AgreementTypeRequest dto) {
        return new ResponseEntity<>(agreementTypeService.toDTO(agreementTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AgreementTypeResponse>> getAll() {
        return ResponseEntity.ok(agreementTypeService.getAll().stream().map(agreementTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgreementTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(agreementTypeService.toDTO(agreementTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<AgreementTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(agreementTypeService.toDTO(agreementTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AgreementTypeResponse> update(@PathVariable Long id, @RequestBody @Valid AgreementTypeRequest dto) {
      return  ResponseEntity.ok(agreementTypeService.toDTO(agreementTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agreementTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
