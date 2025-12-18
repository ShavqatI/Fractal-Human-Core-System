package com.fractal.controller.profile;


import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.profile.relative.ProfileRelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/relative")
@RequiredArgsConstructor
public class ProfileRelativeController {

    private final ProfileRelativeService relativeService;
    @GetMapping
    public ResponseEntity<List<RelativeResponse>> getAll() {
        return ResponseEntity.ok(relativeService.getAll().stream().map(relativeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelativeResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(relativeService.toDTO(relativeService.getById(id)));
    }


}
