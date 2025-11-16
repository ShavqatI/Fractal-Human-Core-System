package com.fractal.domain.dictionary.measurement_unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Long> {
    Optional<MeasurementUnit> findById(Long id);

    Optional<MeasurementUnit> findByCode(String code);

    List<MeasurementUnit> findAll();
}
