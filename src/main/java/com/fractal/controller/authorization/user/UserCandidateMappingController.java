package com.fractal.controller.authorization.user;


import com.fractal.domain.authorization.mapping.user_candidate.UserCandidateMappingService;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingRequest;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authorization/user-candidate-mapping")
@RequiredArgsConstructor
public class UserCandidateMappingController {

    private final UserCandidateMappingService userCandidateMappingService;

    @PostMapping
    public ResponseEntity<UserCandidateMappingResponse> create(@RequestBody @Valid UserCandidateMappingRequest dto) {
        return new ResponseEntity<>(userCandidateMappingService.toDTO(userCandidateMappingService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserCandidateMappingResponse>> getAll() {
        return ResponseEntity.ok(userCandidateMappingService.getAll().stream().map(userCandidateMappingService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCandidateMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userCandidateMappingService.toDTO(userCandidateMappingService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserCandidateMappingResponse> update(@PathVariable Long id, @RequestBody @Valid UserCandidateMappingRequest dto) {
        return ResponseEntity.ok(userCandidateMappingService.toDTO(userCandidateMappingService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userCandidateMappingService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
