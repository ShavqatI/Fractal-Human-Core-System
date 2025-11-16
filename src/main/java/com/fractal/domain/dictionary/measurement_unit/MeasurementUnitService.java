package com.fractal.domain.dictionary.measurement_unit;

import com.fractal.domain.dictionary.measurement_unit.dto.MeasurementUnitRequest;
import com.fractal.domain.dictionary.measurement_unit.dto.MeasurementUnitResponse;

import java.util.List;

public interface MeasurementUnitService {

    MeasurementUnit create(MeasurementUnitRequest dto);

    List<MeasurementUnit> getAll();

    MeasurementUnit getByCode(String code);

    MeasurementUnit getById(Long id);

    MeasurementUnit update(Long id, MeasurementUnitRequest dto);

    void deleteById(Long id);

    MeasurementUnitResponse toDTO(MeasurementUnit measurementUnit);
}
