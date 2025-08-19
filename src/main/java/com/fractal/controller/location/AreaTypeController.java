package com.fractal.controller.location;


import com.fractal.domain.location.area_type.AreaTypeService;
import com.fractal.domain.location.area_type.dto.AreaTypeRequest;
import com.fractal.domain.location.area_type.dto.AreaTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/location/area-type")
@RequiredArgsConstructor
public class AreaTypeController {

    private final AreaTypeService areaTypeService;
    @PostMapping
    public ResponseEntity<AreaTypeResponse> create(@RequestBody @Valid AreaTypeRequest dto) {
        return new ResponseEntity<>(areaTypeService.toDTO(areaTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AreaTypeResponse>> getAll() {
        return ResponseEntity.ok(areaTypeService.getAll().stream().map(areaTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AreaTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(areaTypeService.toDTO(areaTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<AreaTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(areaTypeService.toDTO(areaTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AreaTypeResponse> update(@PathVariable Long id, @RequestBody @Valid AreaTypeRequest dto) {
      return  ResponseEntity.ok(areaTypeService.toDTO(areaTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        areaTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
