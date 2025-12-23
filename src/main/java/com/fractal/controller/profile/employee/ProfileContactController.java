package com.fractal.controller.profile.employee;


import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.profile.contact.ProfileContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/contact")
@RequiredArgsConstructor
public class ProfileContactController {

    private final ProfileContactService contactService;
    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll() {
        return ResponseEntity.ok(contactService.getAll().stream().map(contactService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.toDTO(contactService.getById(id)));
    }


}
