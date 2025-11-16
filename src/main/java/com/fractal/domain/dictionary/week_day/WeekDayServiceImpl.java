package com.fractal.domain.dictionary.week_day;

import com.fractal.domain.dictionary.week_day.dto.WeekDayRequest;
import com.fractal.domain.dictionary.week_day.dto.WeekDayResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class WeekDayServiceImpl implements WeekDayService {

    private final WeekDayRepository weekDayRepository;

    @Override
    public WeekDay create(WeekDayRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<WeekDay> getAll() {
        return weekDayRepository.findAll();
    }

    @Override
    public WeekDay getByCode(String code) {
        return weekDayRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Week Day with code: " + code + " not found"));
    }

    @Override
    public WeekDay getById(Long id) {
        return findById(id);
    }

    @Override
    public WeekDay update(Long id, WeekDayRequest dto) {
        try {
            WeekDay weekDay = findById(id);
            weekDay.setCode(dto.code());
            weekDay.setName(dto.name());
            weekDay.setIndex(dto.index());
            return save(weekDay);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        weekDayRepository.delete(findById(id));
    }

    @Override
    public WeekDayResponse toDTO(WeekDay weekDay) {
        return new WeekDayResponse(
                weekDay.getId(),
                weekDay.getCode(),
                weekDay.getName(),
                weekDay.getIndex(),
                weekDay.getCreatedDate()
        );
    }

    private WeekDay toEntity(WeekDayRequest dto) {
        return WeekDay.builder()
                .code(dto.code())
                .name(dto.name())
                .index(dto.index())
                .build();
    }

    private WeekDay save(WeekDay weekDay) {
        try {
            return weekDayRepository.save(weekDay);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private WeekDay findById(Long id) {
        return weekDayRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Week Day with id: " + id + " not found"));
    }
}
