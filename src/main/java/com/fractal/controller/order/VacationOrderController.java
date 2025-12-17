package com.fractal.controller.order;


import com.fractal.domain.order.vacation.VacationOrderService;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/vacation")
@RequiredArgsConstructor
public class VacationOrderController {

    private final VacationOrderService orderService;
    private final FileService fileService;
    @PostMapping()
    public ResponseEntity<VacationOrderResponse> create( @RequestBody @Valid VacationOrderRequest dto) {
        return new ResponseEntity<>(orderService.toDTO(orderService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VacationOrderResponse>> getAll() {
        return ResponseEntity.ok(orderService.getAll().stream().map(orderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationOrderResponse> getById( @PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacationOrderResponse> update(@PathVariable Long id, @RequestBody @Valid VacationOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(id, dto)));
    }

    @PutMapping("review/{id}")
    public ResponseEntity<VacationOrderResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.review(id)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<VacationOrderResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.approve(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("print/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<StreamingResponseBody> print( @PathVariable Long id) {
        Path path = orderService.print(id);
        return fileService.view(path);
    }

}
