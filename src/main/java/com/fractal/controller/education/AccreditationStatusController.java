package com.fractal.controller.education;


import com.fractal.domain.education.accreditation_status.AccreditationStatusService;
import com.fractal.domain.education.accreditation_status.dto.AccreditationStatusRequest;
import com.fractal.domain.education.accreditation_status.dto.AccreditationStatusResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/education/accreditation-status")
@RequiredArgsConstructor
public class AccreditationStatusController {

    private final AccreditationStatusService accreditationStatusService;
    @PostMapping
    public ResponseEntity<AccreditationStatusResponse> create(@RequestBody @Valid AccreditationStatusRequest dto) {
        return new ResponseEntity<>(accreditationStatusService.toDTO(accreditationStatusService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AccreditationStatusResponse>> getAll() {
        return ResponseEntity.ok(accreditationStatusService.getAll().stream().map(accreditationStatusService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccreditationStatusResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(accreditationStatusService.toDTO(accreditationStatusService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<AccreditationStatusResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(accreditationStatusService.toDTO(accreditationStatusService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AccreditationStatusResponse> update(@PathVariable Long id, @RequestBody @Valid AccreditationStatusRequest dto) {
      return  ResponseEntity.ok(accreditationStatusService.toDTO(accreditationStatusService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accreditationStatusService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
