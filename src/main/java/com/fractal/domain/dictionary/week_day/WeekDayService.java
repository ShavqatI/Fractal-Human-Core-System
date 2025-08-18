package com.fractal.domain.dictionary.week_day;

import com.fractal.domain.dictionary.week_day.dto.WeekDayRequest;
import com.fractal.domain.dictionary.week_day.dto.WeekDayResponse;

import java.util.List;

public interface WeekDayService {

    WeekDay create(WeekDayRequest dto);
    List<WeekDay> getAll();
    WeekDay getByCode(String code);
    WeekDay getById(Long id);
    WeekDay update(Long id, WeekDayRequest dto);
    void deleteById(Long id);
    WeekDayResponse toDTO(WeekDay weekDay);
}
