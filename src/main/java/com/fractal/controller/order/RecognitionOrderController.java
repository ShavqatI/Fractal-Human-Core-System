package com.fractal.controller.order;


import com.fractal.domain.order.recognition.RecognitionOrderService;
import com.fractal.domain.order.recognition.dto.RecognitionOrderSalaryRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;
import com.fractal.domain.order.recognition.dto.RecognitionOrderUploadExcelRequest;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order-management/recognition")
@RequiredArgsConstructor
public class RecognitionOrderController {

    private final RecognitionOrderService orderService;
    private final FileService fileService;

    @PostMapping(value = "/excel",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<RecognitionOrderResponse>> createFromExcel(@ModelAttribute RecognitionOrderUploadExcelRequest dto) {
        return ResponseEntity.ok(orderService.createFromExcelFile(dto).stream().map(orderService::toDTO).collect(Collectors.toList()));
    }
    @PostMapping(value = "/decrease-salary")
    public ResponseEntity<RecognitionOrderResponse> decreaseSalary(@RequestBody RecognitionOrderSalaryRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.decreaseSalary(dto)));
    }
    @PostMapping(value = "/increase-salary")
    public ResponseEntity<RecognitionOrderResponse> increaseSalary(@RequestBody RecognitionOrderSalaryRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.increaseSalary(dto)));
    }


    @GetMapping
    public ResponseEntity<List<RecognitionOrderResponse>> getAll() {
        return ResponseEntity.ok(orderService.getAll().stream().map(orderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecognitionOrderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecognitionOrderResponse> update(@PathVariable Long id, @RequestBody @Valid RecognitionOrderRequest dto) {
        return ResponseEntity.ok(orderService.toDTO(orderService.update(id, dto)));
    }
    @PutMapping("review/{id}")
    public ResponseEntity<RecognitionOrderResponse> review(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.review(id)));
    }

    @PutMapping("approve/{id}")
    public ResponseEntity<RecognitionOrderResponse> approve(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.approve(id)));
    }
    @PutMapping("cancel/{id}")
    public ResponseEntity<RecognitionOrderResponse> cancel(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.toDTO(orderService.cancel(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("print/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<StreamingResponseBody> print(@PathVariable Long id) {
        Path path = orderService.print(id);
        return fileService.view(path);
    }


}
