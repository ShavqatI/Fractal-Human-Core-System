package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/language-skill")
@RequiredArgsConstructor
public class CandidateLanguageSkillController {

    private final CandidateLanguageSkillService languageSkillService;

    @PostMapping()
    public ResponseEntity<LanguageSkillResponse> create(@PathVariable Long candidateId, @RequestBody @Valid LanguageSkillRequest dto) {
        return new ResponseEntity<>(languageSkillService.toDTO(languageSkillService.create(candidateId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LanguageSkillResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(languageSkillService.getAllByCandidateId(candidateId).stream().map(languageSkillService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageSkillResponse> getById(@PathVariable Long candidateId, @PathVariable Long id) {
        return ResponseEntity.ok(languageSkillService.toDTO(languageSkillService.getById(candidateId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageSkillResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid LanguageSkillRequest dto) {
        return ResponseEntity.ok(languageSkillService.toDTO(languageSkillService.update(candidateId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        languageSkillService.delete(candidateId, id);
        return ResponseEntity.noContent().build();
    }

}
