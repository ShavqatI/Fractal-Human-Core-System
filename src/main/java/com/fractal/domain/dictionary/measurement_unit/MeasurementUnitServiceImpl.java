package com.fractal.domain.dictionary.measurement_unit;

import com.fractal.domain.dictionary.measurement_unit.dto.MeasurementUnitRequest;
import com.fractal.domain.dictionary.measurement_unit.dto.MeasurementUnitResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class MeasurementUnitServiceImpl implements MeasurementUnitService {

    private final MeasurementUnitRepository measurementUnitRepository;

    @Override
    public MeasurementUnit create(MeasurementUnitRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<MeasurementUnit> getAll() {
        return measurementUnitRepository.findAll();
    }

    @Override
    public MeasurementUnit getByCode(String code) {
        return measurementUnitRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Measurement Unit with code: " + code + " not found"));
    }

    @Override
    public MeasurementUnit getById(Long id) {
        return findById(id);
    }

    @Override
    public MeasurementUnit update(Long id, MeasurementUnitRequest dto) {
        try {
            MeasurementUnit measurementUnit = findById(id);
            measurementUnit.setCode(dto.code());
            measurementUnit.setName(dto.name());
            return save(measurementUnit);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       measurementUnitRepository.delete(findById(id));
    }

    @Override
    public MeasurementUnitResponse toDTO(MeasurementUnit measurementUnit) {
        return new MeasurementUnitResponse(
                measurementUnit.getId(),
                measurementUnit.getCode(),
                measurementUnit.getName(),
                measurementUnit.getCreatedDate()
        );
    }

    private MeasurementUnit toEntity(MeasurementUnitRequest dto) {
        return MeasurementUnit.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private MeasurementUnit save(MeasurementUnit measurementUnit) {
        try {
            return measurementUnitRepository.save(measurementUnit);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private MeasurementUnit findById(Long id) {
        return measurementUnitRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Measurement Unit with id: " + id + " not found"));
    }
}
