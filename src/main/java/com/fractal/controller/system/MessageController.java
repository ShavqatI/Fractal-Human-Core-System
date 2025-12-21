package com.fractal.controller.system;


import com.fractal.domain.system.message.MessageService;
import com.fractal.domain.system.message.dto.MessageCompactResponse;
import com.fractal.domain.system.message.dto.MessageRequest;
import com.fractal.domain.system.message.dto.MessageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/system/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid MessageRequest dto) {
        return new ResponseEntity<>(messageService.toDTO(messageService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MessageResponse>> getAll() {
        return ResponseEntity.ok(messageService.getAll().stream().map(messageService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.toDTO(messageService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<MessageResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(messageService.toDTO(messageService.getByCode(code)));
    }
    @GetMapping("/code/{code}/language/{language}")
    public ResponseEntity<MessageCompactResponse> getByCodeAndLanguage(@PathVariable String code, @PathVariable String language) {
        return ResponseEntity.ok(messageService.toCompactDTO(messageService.getByCodeAndLanguage(code,language)));
    }
    @PostMapping("/codes/language/{language}")
    public ResponseEntity<List<MessageCompactResponse>> getByCodesAndLanguage(@RequestBody List<String> codes, @PathVariable String language) {
        return ResponseEntity.ok(messageService.getByCodesAndLanguage(codes,language).stream().map(messageService::toCompactDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @RequestBody @Valid MessageRequest dto) {
        return ResponseEntity.ok(messageService.toDTO(messageService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
