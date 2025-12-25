package com.fractal.controller.profile.candidate;


import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.profile.candidate.language_skill.CandidateProfileLanguageSkillService;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/language-skill")
@RequiredArgsConstructor
public class CandidateProfileLanguageSkillController {

    private final CandidateProfileLanguageSkillService languageSkillService;

    @PostMapping()
    public ResponseEntity<LanguageSkillResponse> create(@RequestBody @Valid LanguageSkillRequest dto) {
        return new ResponseEntity<>(languageSkillService.toDTO(languageSkillService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LanguageSkillResponse>> getAll() {
        return ResponseEntity.ok(languageSkillService.getAll().stream().map(languageSkillService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageSkillResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(languageSkillService.toDTO(languageSkillService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageSkillResponse> update(@PathVariable Long id, @RequestBody @Valid LanguageSkillRequest dto) {
        return ResponseEntity.ok(languageSkillService.toDTO(languageSkillService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        languageSkillService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
