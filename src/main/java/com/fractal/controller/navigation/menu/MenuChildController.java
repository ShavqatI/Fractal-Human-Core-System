package com.fractal.controller.navigation.menu;

import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/navigation/menu/{menuId}/child")
@RequiredArgsConstructor
public class MenuChildController {

    private final MenuService menuService;

    @PostMapping()
    public ResponseEntity<MenuResponse> create(@PathVariable Long menuId, @RequestBody @Valid MenuRequest dto) {
        return new ResponseEntity<>(menuService.toDTO(menuService.addChild(menuId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MenuResponse> update(@PathVariable Long menuId, @PathVariable Long id, @RequestBody @Valid MenuRequest dto) {
        return ResponseEntity.ok(menuService.toDTO(menuService.updateChild(menuId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long menuId, @PathVariable Long id) {
        menuService.deleteChild(menuId,id);
        return ResponseEntity.noContent().build();
    }
}
