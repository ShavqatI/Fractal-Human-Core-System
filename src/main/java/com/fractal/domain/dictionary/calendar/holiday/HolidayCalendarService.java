package com.fractal.domain.dictionary.calendar.holiday;

import com.fractal.domain.dictionary.calendar.holiday.dto.HolidayCalenderRequest;
import com.fractal.domain.dictionary.calendar.holiday.dto.HolidayCalenderResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HolidayCalendarService {

    HolidayCalendar create(HolidayCalenderRequest dto);

    List<HolidayCalendar> getAll();

    HolidayCalendar getByCode(String code);
    Optional<HolidayCalendar> getByDate(LocalDate date);
    List<HolidayCalendar> getByDates(LocalDate startDate, LocalDate endDate);
    HolidayCalendar getById(Long id);

    HolidayCalendar update(Long id, HolidayCalenderRequest dto);

    void deleteById(Long id);

    HolidayCalenderResponse toDTO(HolidayCalendar holidayCalendar);
}
