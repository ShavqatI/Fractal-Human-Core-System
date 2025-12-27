package com.fractal.controller.profile.employee;


import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.profile.employee.identification_document.ProfileIdentificationDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/identification-document")
@RequiredArgsConstructor
public class ProfileIdentificationDocumentController {

    private final ProfileIdentificationDocumentService identificationDocumentService;
    @GetMapping
    public ResponseEntity<List<IdentificationDocumentResponse>> getAll() {
        return ResponseEntity.ok(identificationDocumentService.getAll().stream().map(identificationDocumentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdentificationDocumentResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(identificationDocumentService.toDTO(identificationDocumentService.getById(id)));
    }


}
