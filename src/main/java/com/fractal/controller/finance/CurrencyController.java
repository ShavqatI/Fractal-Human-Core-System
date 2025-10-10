package com.fractal.controller.finance;

import com.fractal.domain.finance.currency.CurrencyService;
import com.fractal.domain.finance.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.finance.currency.dto.CurrencyRequest;
import com.fractal.domain.finance.currency.dto.CurrencyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/finance/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;


    @PostMapping
    public ResponseEntity<CurrencyResponse> create(@RequestBody @Valid CurrencyRequest dto) {
        return new ResponseEntity<>(currencyService.toDTO(currencyService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CurrencyResponse>> getAll() {
        return ResponseEntity.ok(currencyService.getAll().stream().map(currencyService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CurrencyResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(currencyService.toDTO(currencyService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<CurrencyResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(currencyService.toDTO(currencyService.getByCode(code)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<CurrencyCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(currencyService.getAll().stream().map(currencyService::toCompactDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CurrencyResponse> update(@PathVariable Long id, @RequestBody @Valid CurrencyRequest dto) {
      return  ResponseEntity.ok(currencyService.toDTO(currencyService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        currencyService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
