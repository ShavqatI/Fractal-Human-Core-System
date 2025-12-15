package com.fractal.controller.system;


import com.fractal.domain.order.type.dto.OrderTypeRequest;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.system.message.type.MessageTypeService;
import com.fractal.domain.system.message.type.dto.MessageTypeRequest;
import com.fractal.domain.system.message.type.dto.MessageTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/system/message/type")
@RequiredArgsConstructor
public class MessageTypeController {

    private final MessageTypeService messageTypeService;

    @PostMapping
    public ResponseEntity<MessageTypeResponse> create(@RequestBody @Valid MessageTypeRequest dto) {
        return new ResponseEntity<>(messageTypeService.toDTO(messageTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MessageTypeResponse>> getAll() {
        return ResponseEntity.ok(messageTypeService.getAll().stream().map(messageTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(messageTypeService.toDTO(messageTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<MessageTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(messageTypeService.toDTO(messageTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageTypeResponse> update(@PathVariable Long id, @RequestBody @Valid MessageTypeRequest dto) {
        return ResponseEntity.ok(messageTypeService.toDTO(messageTypeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
