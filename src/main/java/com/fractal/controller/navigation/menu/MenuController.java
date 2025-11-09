package com.fractal.controller.navigation.menu;

import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.domain.navigation.menu.dto.MenuCompactResponse;
import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/navigation/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<MenuResponse> create(@RequestBody @Valid MenuRequest dto) {
        return new ResponseEntity<>(menuService.toDTO(menuService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MenuResponse>> getAll() {
        return ResponseEntity.ok(menuService.getAll().stream().map(menuService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/top-level")
    public ResponseEntity<List<MenuResponse>> getAllTopLevel() {
        return ResponseEntity.ok(menuService.getAllTopLevel().stream().map(menuService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<MenuCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(menuService.getAll().stream().map(menuService::toCompactDTO).collect(Collectors.toList()));
    }



    @GetMapping("/{id}")
    public ResponseEntity<MenuResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(menuService.toDTO(menuService.getById(id)));
    }
    @GetMapping("/url/{url}")
    public ResponseEntity<MenuResponse> getByUrl(@PathVariable String url) {
        return ResponseEntity.ok(menuService.toDTO(menuService.getByUrl(url)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MenuResponse> update(@PathVariable Long id, @RequestBody @Valid MenuRequest dto) {
        return ResponseEntity.ok(menuService.toDTO(menuService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
