package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.week_day.WeekDayService;
import com.fractal.domain.dictionary.week_day.dto.WeekDayRequest;
import com.fractal.domain.dictionary.week_day.dto.WeekDayResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/week-day")
@RequiredArgsConstructor
public class WeekDayController {

    private final WeekDayService weekDayService;
    @PostMapping
    public ResponseEntity<WeekDayResponse> create(@RequestBody @Valid WeekDayRequest dto) {
        return new ResponseEntity<>(weekDayService.toDTO(weekDayService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<WeekDayResponse>> getAll() {
        return ResponseEntity.ok(weekDayService.getAll().stream().map(weekDayService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WeekDayResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(weekDayService.toDTO(weekDayService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<WeekDayResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(weekDayService.toDTO(weekDayService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<WeekDayResponse> update(@PathVariable Long id, @RequestBody @Valid WeekDayRequest dto) {
      return  ResponseEntity.ok(weekDayService.toDTO(weekDayService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        weekDayService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
