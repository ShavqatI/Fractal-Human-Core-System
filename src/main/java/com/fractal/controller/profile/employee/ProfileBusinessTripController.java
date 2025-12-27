package com.fractal.controller.profile.employee;


import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.profile.employee.business_trip.ProfileBusinessTripRequest;
import com.fractal.domain.profile.employee.business_trip.ProfileBusinessTripService;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/business-trip")
@RequiredArgsConstructor
public class ProfileBusinessTripController {

    private final ProfileBusinessTripService businessTripService;
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<BusinessTripResponse> create(@RequestBody @Valid ProfileBusinessTripRequest dto) {
        return new ResponseEntity<>(businessTripService.toDTO(businessTripService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripResponse>> getAll() {
        return ResponseEntity.ok(businessTripService.getAll().stream().map(businessTripService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripResponse> update(@PathVariable Long id, @RequestBody @Valid ProfileBusinessTripRequest dto) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<BusinessTripResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.review(id)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        businessTripService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("passport/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<StreamingResponseBody> passport(@PathVariable Long id) {
        Path path = businessTripService.passport(id);
        return fileService.view(path);
    }
}
