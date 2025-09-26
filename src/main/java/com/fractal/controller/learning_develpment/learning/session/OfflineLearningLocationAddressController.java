package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.location.offline.address.OfflineLearningLocationAddressService;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto.OfflineLearningLocationAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/location/offline/{locationId}/address")
@RequiredArgsConstructor
public class OfflineLearningLocationAddressController {

    private final OfflineLearningLocationAddressService addressService;

    @PostMapping
    public ResponseEntity<OfflineLearningLocationAddressResponse> create(@PathVariable Long locationId, @RequestBody @Valid OfflineLearningLocationAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create(locationId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<OfflineLearningLocationAddressResponse>> getAll(@PathVariable Long locationId) {
        return ResponseEntity.ok(addressService.getAllByOfflineLearningLocationId(locationId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OfflineLearningLocationAddressResponse> getById(@PathVariable Long locationId, @PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(locationId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OfflineLearningLocationAddressResponse> update(@PathVariable Long locationId, @PathVariable Long id, @RequestBody @Valid OfflineLearningLocationAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(locationId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long locationId, @PathVariable Long id) {
        addressService.delete(locationId,id);
        return ResponseEntity.noContent().build();
    }

}
