package com.fractal.controller.navigation.menu;

import com.fractal.domain.navigation.menu.action.MenuActionService;
import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/navigation/menu/{menuId}/action")
@RequiredArgsConstructor
public class MenuActionController {

    private final MenuActionService menuActionService;

    @PostMapping("")
    public ResponseEntity<MenuActionResponse> create(@PathVariable Long menuId, @RequestBody @Valid MenuActionRequest dto) {
        return new ResponseEntity<>(menuActionService.toDTO(menuActionService.create(menuId,dto)), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MenuActionResponse> getById(@PathVariable Long menuId, @PathVariable Long id) {
        return ResponseEntity.ok(menuActionService.toDTO(menuActionService.getById(menuId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MenuActionResponse> update(@PathVariable Long menuId, @PathVariable Long id, @RequestBody @Valid MenuActionRequest dto) {
        return ResponseEntity.ok(menuActionService.toDTO(menuActionService.update(menuId,id, dto)));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long menuId, @PathVariable Long id) {
        menuActionService.delete(menuId,id);
        return ResponseEntity.noContent().build();
    }

}
