package com.fractal.controller.employee_management.business_trip;


import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.employee_management.vacation.dto.VacationRequest;
import com.fractal.domain.employee_management.vacation.dto.VacationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/business-trip")
@RequiredArgsConstructor
public class BusinessTripController {

    private final BusinessTripService businessTripService;
    @PostMapping
    public ResponseEntity<BusinessTripResponse> create(@RequestBody @Valid BusinessTripRequest dto) {
        return new ResponseEntity<>(businessTripService.toDTO(businessTripService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<BusinessTripResponse>> getAll() {
        return ResponseEntity.ok(businessTripService.getAll().stream().map(businessTripService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusinessTripResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.getById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripResponse> update(@PathVariable Long id, @RequestBody @Valid BusinessTripRequest dto) {
      return  ResponseEntity.ok(businessTripService.toDTO(businessTripService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        businessTripService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
