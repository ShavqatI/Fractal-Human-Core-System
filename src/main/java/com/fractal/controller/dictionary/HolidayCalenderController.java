package com.fractal.controller.dictionary;


import com.fractal.domain.dictionary.calendar.holiday.HolidayCalendarService;
import com.fractal.domain.dictionary.calendar.holiday.dto.HolidayCalenderRequest;
import com.fractal.domain.dictionary.calendar.holiday.dto.HolidayCalenderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dictionary/calender/holiday")
@RequiredArgsConstructor
public class HolidayCalenderController {

    private final HolidayCalendarService calenderService;

    @PostMapping
    public ResponseEntity<HolidayCalenderResponse> create(@RequestBody @Valid HolidayCalenderRequest dto) {
        return new ResponseEntity<>(calenderService.toDTO(calenderService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HolidayCalenderResponse>> getAll() {
        return ResponseEntity.ok(calenderService.getAll().stream().map(calenderService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayCalenderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(calenderService.toDTO(calenderService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<HolidayCalenderResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(calenderService.toDTO(calenderService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HolidayCalenderResponse> update(@PathVariable Long id, @RequestBody @Valid HolidayCalenderRequest dto) {
        return ResponseEntity.ok(calenderService.toDTO(calenderService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        calenderService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
