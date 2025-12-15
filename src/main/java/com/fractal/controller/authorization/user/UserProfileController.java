package com.fractal.controller.authorization.user;


import com.fractal.domain.authorization.user.dto.*;
import com.fractal.domain.authorization.user.profile.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authorization/user/profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    /*@GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById() {
        return ResponseEntity.ok(userProfileService.toDTO(userProfileService.getById(id)));
    }*/

    @PutMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody @Valid ChangePasswordRequest dto) {
        userProfileService.changePassword(dto);
        return ResponseEntity.noContent().build();
    }

}
