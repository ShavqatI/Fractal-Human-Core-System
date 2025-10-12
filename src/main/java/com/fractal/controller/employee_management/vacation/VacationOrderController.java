package com.fractal.controller.employee_management.vacation;


import com.fractal.domain.employee_management.vacation.order.VacationOrderService;
import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderRequest;
import com.fractal.domain.employee_management.vacation.order.dto.VacationOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/vacation/{vacationId}/order")
@RequiredArgsConstructor
public class VacationOrderController {

    private final VacationOrderService orderService;

    @PostMapping()
    public ResponseEntity<VacationOrderResponse> create(@PathVariable Long vacationId, @RequestBody @Valid VacationOrderRequest dto) {
        return new ResponseEntity<>(orderService.toDTO(orderService.create(vacationId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VacationOrderResponse>> getAll(@PathVariable Long vacationId) {
        return ResponseEntity.ok(orderService.getAllByVacationId(vacationId).stream().map(orderService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VacationOrderResponse> getById(@PathVariable Long vacationId, @PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(vacationId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VacationOrderResponse> update(@PathVariable Long vacationId, @PathVariable Long id, @RequestBody @Valid VacationOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(vacationId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long vacationId, @PathVariable Long id) {
        orderService.delete(vacationId,id);
        return ResponseEntity.noContent().build();
    }



}
