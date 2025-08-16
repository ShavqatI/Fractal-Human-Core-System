package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.recruitment.candidate.address.CandidateAddressService;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/address")
@RequiredArgsConstructor
public class CandidateAddressController {

    private final CandidateAddressService addressService;

    @PostMapping()
    public ResponseEntity<CandidateAddressResponse> create(@PathVariable Long candidateId, @RequestBody @Valid CandidateAddressRequest dto) {
        return new ResponseEntity<>(addressService.toDTO(addressService.create(candidateId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CandidateAddressResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(addressService.getAllByCandidateId(candidateId).stream().map(addressService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CandidateAddressResponse> getById(@PathVariable Long candidateId, @PathVariable Long id) {
        return ResponseEntity.ok(addressService.toDTO(addressService.getById(candidateId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CandidateAddressResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid CandidateAddressRequest dto) {
        return ResponseEntity.ok(addressService.toDTO(addressService.update(candidateId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        addressService.delete(candidateId,id);
        return ResponseEntity.noContent().build();
    }

}
