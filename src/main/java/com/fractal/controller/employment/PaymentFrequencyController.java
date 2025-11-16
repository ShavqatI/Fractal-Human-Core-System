package com.fractal.controller.employment;


import com.fractal.domain.employment.payment_frequency.PaymentFrequencyService;
import com.fractal.domain.employment.payment_frequency.dto.PaymentFrequencyRequest;
import com.fractal.domain.employment.payment_frequency.dto.PaymentFrequencyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/payment-frequency")
@RequiredArgsConstructor
public class PaymentFrequencyController {

    private final PaymentFrequencyService paymentFrequencyService;

    @PostMapping
    public ResponseEntity<PaymentFrequencyResponse> create(@RequestBody @Valid PaymentFrequencyRequest dto) {
        return new ResponseEntity<>(paymentFrequencyService.toDTO(paymentFrequencyService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PaymentFrequencyResponse>> getAll() {
        return ResponseEntity.ok(paymentFrequencyService.getAll().stream().map(paymentFrequencyService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentFrequencyResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentFrequencyService.toDTO(paymentFrequencyService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<PaymentFrequencyResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(paymentFrequencyService.toDTO(paymentFrequencyService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentFrequencyResponse> update(@PathVariable Long id, @RequestBody @Valid PaymentFrequencyRequest dto) {
        return ResponseEntity.ok(paymentFrequencyService.toDTO(paymentFrequencyService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paymentFrequencyService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
