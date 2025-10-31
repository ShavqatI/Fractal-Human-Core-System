package com.fractal.controller.employee_management.business_trip.location;


import com.fractal.domain.employee_management.business_trip.location.type.BusinessTripLocationTypeService;
import com.fractal.domain.employee_management.business_trip.location.type.dto.BusinessTripLocationTypeRequest;
import com.fractal.domain.employee_management.business_trip.location.type.dto.BusinessTripLocationTypeResponse;
import com.fractal.domain.learning_develpment.learning.session.location.type.LearningLocationTypeService;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip/location-type")
@RequiredArgsConstructor
public class BusinessTripLocationTypeController {

    private final BusinessTripLocationTypeService locationTypeService;
    @PostMapping
    public ResponseEntity<BusinessTripLocationTypeResponse> create(@RequestBody @Valid BusinessTripLocationTypeRequest dto) {
        return new ResponseEntity<>(locationTypeService.toDTO(locationTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BusinessTripLocationTypeResponse>> getAll() {
        return ResponseEntity.ok(locationTypeService.getAll().stream().map(locationTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripLocationTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(locationTypeService.toDTO(locationTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<BusinessTripLocationTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(locationTypeService.toDTO(locationTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripLocationTypeResponse> update(@PathVariable Long id, @RequestBody @Valid BusinessTripLocationTypeRequest dto) {
      return  ResponseEntity.ok(locationTypeService.toDTO(locationTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
