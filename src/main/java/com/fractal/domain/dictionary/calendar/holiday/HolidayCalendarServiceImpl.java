package com.fractal.domain.dictionary.calendar.holiday;

import com.fractal.domain.dictionary.calendar.holiday.dto.HolidayCalenderRequest;
import com.fractal.domain.dictionary.calendar.holiday.dto.HolidayCalenderResponse;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
class HolidayCalendarServiceImpl implements HolidayCalendarService {

    private final HolidayCalendarRepository holidayCalendarRepository;

    @Override
    public HolidayCalendar create(HolidayCalenderRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<HolidayCalendar> getAll() {
        return holidayCalendarRepository.findAll();
    }

    @Override
    public HolidayCalendar getByCode(String code) {
        return holidayCalendarRepository.findByCode(code).orElseThrow(() -> new ResourceWithCodeNotFoundException(this,code));
    }

    @Override
    public Optional<HolidayCalendar> getByDate(LocalDate date) {
        return holidayCalendarRepository.findByDate(date);
    }

    @Override
    public List<HolidayCalendar> getByDates(LocalDate startDate, LocalDate endDate) {
        return holidayCalendarRepository.findAllByDateBetween(startDate,endDate);
    }

    @Override
    public HolidayCalendar getById(Long id) {
        return findById(id);
    }

    @Override
    public HolidayCalendar update(Long id, HolidayCalenderRequest dto) {
        try {
            HolidayCalendar holidayCalendar = findById(id);
            holidayCalendar.setCode(dto.code());
            holidayCalendar.setName(dto.name());
            holidayCalendar.setDate(dto.date());
            return save(holidayCalendar);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        holidayCalendarRepository.delete(findById(id));
    }

    @Override
    public HolidayCalenderResponse toDTO(HolidayCalendar holidayCalendar) {
        return new HolidayCalenderResponse(
                holidayCalendar.getId(),
                holidayCalendar.getCode(),
                holidayCalendar.getName(),
                holidayCalendar.getDate(),
                holidayCalendar.getCreatedDate()
        );
    }

    private HolidayCalendar toEntity(HolidayCalenderRequest dto) {
        return HolidayCalendar.builder()
                .code(dto.code())
                .name(dto.name())
                .date(dto.date())
                .build();
    }

    private HolidayCalendar save(HolidayCalendar holidayCalendar) {
        try {
            return holidayCalendarRepository.save(holidayCalendar);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private HolidayCalendar findById(Long id) {
        return holidayCalendarRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }
}
