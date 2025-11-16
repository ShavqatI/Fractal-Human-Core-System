package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.recruitment.candidate.resource.type.CandidateResourceTypeService;
import com.fractal.domain.recruitment.candidate.resource.type.dto.CandidateResourceTypeRequest;
import com.fractal.domain.recruitment.candidate.resource.type.dto.CandidateResourceTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/resource-type")
@RequiredArgsConstructor
public class CandidateResourceTypeController {

    private final CandidateResourceTypeService resourceTypeService;

    @PostMapping
    public ResponseEntity<CandidateResourceTypeResponse> create(@RequestBody @Valid CandidateResourceTypeRequest dto) {
        return new ResponseEntity<>(resourceTypeService.toDTO(resourceTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CandidateResourceTypeResponse>> getAll() {
        return ResponseEntity.ok(resourceTypeService.getAll().stream().map(resourceTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResourceTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CandidateResourceTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateResourceTypeResponse> update(@PathVariable Long id, @RequestBody @Valid CandidateResourceTypeRequest dto) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        resourceTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
