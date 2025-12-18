package com.fractal.controller.profile;


import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.profile.language_skill.ProfileLanguageSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/language-skill")
@RequiredArgsConstructor
public class ProfileLanguageSkillController {

    private final ProfileLanguageSkillService languageSkillService;
    @GetMapping
    public ResponseEntity<List<LanguageSkillResponse>> getAll() {
        return ResponseEntity.ok(languageSkillService.getAll().stream().map(languageSkillService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageSkillResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(languageSkillService.toDTO(languageSkillService.getById(id)));
    }


}
