package com.fractal.controller.profile.employee;


import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.profile.employee.citizenship.ProfileCitizenshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/citizenship")
@RequiredArgsConstructor
public class ProfileCitizenshipController {

    private final ProfileCitizenshipService citizenshipService;
    @GetMapping
    public ResponseEntity<List<CitizenshipResponse>> getAll() {
        return ResponseEntity.ok(citizenshipService.getAll().stream().map(citizenshipService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(citizenshipService.toDTO(citizenshipService.getById(id)));
    }


}
