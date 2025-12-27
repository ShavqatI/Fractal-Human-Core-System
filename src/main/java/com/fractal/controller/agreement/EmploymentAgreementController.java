package com.fractal.controller.agreement;


import com.fractal.domain.agreement.employment.EmploymentAgreementService;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementRequest;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementResponse;
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
@RequestMapping("/api/v1/agreement/employment")
@RequiredArgsConstructor
public class EmploymentAgreementController {

    private final EmploymentAgreementService agreementService;
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<EmploymentAgreementResponse> create(@RequestBody @Valid EmploymentAgreementRequest dto) {
        return new ResponseEntity<>(agreementService.toDTO(agreementService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentAgreementResponse>> getAll() {
        return ResponseEntity.ok(agreementService.getAll().stream().map(agreementService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentAgreementResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(agreementService.toDTO(agreementService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentAgreementResponse> update(@PathVariable Long id, @RequestBody @Valid EmploymentAgreementRequest dto) {
        return ResponseEntity.ok(agreementService.toDTO(agreementService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agreementService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("print/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<StreamingResponseBody> print(@PathVariable Long id) {
        Path path = agreementService.print(id);
        return fileService.view(path);
    }
}
