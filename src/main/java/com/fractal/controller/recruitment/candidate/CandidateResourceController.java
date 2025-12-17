package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.recruitment.candidate.resource.CandidateResourceService;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/resource")
@RequiredArgsConstructor
public class CandidateResourceController {

    private final CandidateResourceService resourceService;
    private final FileService fileService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CandidateResourceResponse> create(@PathVariable Long candidateId, @ModelAttribute @Valid CandidateResourceRequest dto) {
        return new ResponseEntity<>(resourceService.toDTO(resourceService.create(candidateId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CandidateResourceResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(resourceService.getAllByCandidateId(candidateId).stream().map(resourceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResourceResponse> getById(@PathVariable Long candidateId, @PathVariable Long id) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.getById(candidateId, id)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CandidateResourceResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @ModelAttribute @Valid CandidateResourceRequest dto) {
        return ResponseEntity.ok(resourceService.toDTO(resourceService.update(candidateId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        resourceService.delete(candidateId, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long candidateId, @PathVariable Long id) {
        var employeeResource = resourceService.getById(candidateId, id);
        try {
            Path filePath = Path.of(employeeResource.getUrl()).toAbsolutePath();
            return fileService.download(filePath);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
