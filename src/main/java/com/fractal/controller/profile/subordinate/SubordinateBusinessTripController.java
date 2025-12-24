package com.fractal.controller.profile.subordinate;


import com.fractal.domain.employee_management.business_trip.dto.BusinessTripCancelRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripProlongRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.profile.business_trip.ProfileBusinessTripRequest;
import com.fractal.domain.profile.business_trip.ProfileBusinessTripService;
import com.fractal.domain.profile.subordinate.business_trip.SubordinateBusinessTripRequest;
import com.fractal.domain.profile.subordinate.business_trip.SubordinateBusinessTripService;
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
@RequestMapping("/api/v1/profile-management/subordinate/business-trip")
@RequiredArgsConstructor
public class SubordinateBusinessTripController {

    private final SubordinateBusinessTripService businessTripService;
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<BusinessTripResponse> create(@RequestBody @Valid SubordinateBusinessTripRequest dto) {
        return new ResponseEntity<>(businessTripService.toDTO(businessTripService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BusinessTripResponse>> getAll() {
        return ResponseEntity.ok(businessTripService.getAll().stream().map(businessTripService::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessTripResponse> update(@PathVariable Long id, @RequestBody @Valid SubordinateBusinessTripRequest dto) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<BusinessTripResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.review(id)));
    }
    @PutMapping("approve/{id}")
    public ResponseEntity<BusinessTripResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.approve(id)));
    }
    @PutMapping("cancel/{id}")
    public ResponseEntity<BusinessTripResponse> cancel(@PathVariable Long id,@RequestBody String reason) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.cancel(new BusinessTripCancelRequest(id,reason))));
    }
    @PutMapping("prolong/{id}")
    public ResponseEntity<BusinessTripResponse> prolong(@PathVariable Long id, @RequestBody @Valid BusinessTripProlongRequest dto ) {
        return ResponseEntity.ok(businessTripService.toDTO(businessTripService.prolong(id,dto)));
    }
    @GetMapping("close/{id}")
    public ResponseEntity<Void> close(@PathVariable Long id) {
        businessTripService.close(id);
        return ResponseEntity.noContent().build();
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
