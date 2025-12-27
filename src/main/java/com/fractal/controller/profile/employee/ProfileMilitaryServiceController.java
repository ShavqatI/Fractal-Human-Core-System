package com.fractal.controller.profile.employee;


import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.profile.employee.military_service.ProfileMilitaryServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/military-service")
@RequiredArgsConstructor
public class ProfileMilitaryServiceController {

    private final ProfileMilitaryServiceService militaryServiceService;
    @GetMapping
    public ResponseEntity<List<MilitaryServiceResponse>> getAll() {
        return ResponseEntity.ok(militaryServiceService.getAll().stream().map(militaryServiceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilitaryServiceResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(militaryServiceService.toDTO(militaryServiceService.getById(id)));
    }


}
