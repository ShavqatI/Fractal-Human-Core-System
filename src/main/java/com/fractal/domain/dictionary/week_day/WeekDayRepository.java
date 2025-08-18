package com.fractal.domain.dictionary.week_day;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface WeekDayRepository extends JpaRepository<WeekDay,Long> {
    Optional<WeekDay> findById(Long id);
    Optional<WeekDay> findByCode(String code);
    List<WeekDay> findAll();
}
