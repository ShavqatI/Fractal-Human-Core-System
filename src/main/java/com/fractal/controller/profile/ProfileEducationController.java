package com.fractal.controller.profile;


import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.profile.education.ProfileEducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/education")
@RequiredArgsConstructor
public class ProfileEducationController {

    private final ProfileEducationService educationService;
    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAll() {
        return ResponseEntity.ok(educationService.getAll().stream().map(educationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(educationService.toDTO(educationService.getById(id)));
    }


}
