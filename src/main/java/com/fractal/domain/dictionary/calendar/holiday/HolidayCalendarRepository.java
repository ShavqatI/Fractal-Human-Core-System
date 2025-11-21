package com.fractal.domain.dictionary.calendar.holiday;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
interface HolidayCalendarRepository extends JpaRepository<HolidayCalendar, Long> {

    Optional<HolidayCalendar> findByCode(String code);
    Optional<HolidayCalendar> findByDate(LocalDate date);

    List<HolidayCalendar> findAllByDateBetween(LocalDate startDate, LocalDate endDate);
}
