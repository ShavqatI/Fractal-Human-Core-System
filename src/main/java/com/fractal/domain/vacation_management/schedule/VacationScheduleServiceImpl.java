package com.fractal.domain.vacation_management.schedule;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleRequest;
import com.fractal.domain.vacation_management.schedule.dto.VacationScheduleResponse;
import com.fractal.domain.vacation_management.schedule.mapper.VacationScheduleMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
class VacationScheduleServiceImpl implements VacationScheduleService {

    private final VacationScheduleRepository vacationScheduleRepository;
    private final VacationScheduleMapperService mapperService;
    private final StatusService statusService;

    @Override
    public VacationSchedule create(VacationScheduleRequest dto) {
       var schedule = save(mapperService.toEntity(dto));
       schedule.setStatus(statusService.getByCode("CREATED"));
       return schedule;
    }

    @Override
    public List<VacationSchedule> getAll() {
        return vacationScheduleRepository.findAll();
    }

    @Override
    public VacationSchedule getById(Long id) {
        return findById(id);
    }

    @Override
    public List<VacationSchedule> getAllByEmployeeId(Long employeeId) {
        return vacationScheduleRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public VacationSchedule update(Long id, VacationScheduleRequest dto) {
        try {
           return save(mapperService.toEntity(findById(id),dto));
       }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        vacationScheduleRepository.delete(findById(id));
    }

    public VacationScheduleResponse toDTO(VacationSchedule schedule) {
        return mapperService.toDTO(schedule);
    }

    @Override
    public VacationSchedule save(VacationSchedule schedule) {
        try {
            return vacationScheduleRepository.save(schedule);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationSchedule findById(Long id) {
        return vacationScheduleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vacation with id: " + id + " not found"));
    }

    @Override
    public VacationSchedule review(Long id) {
        var schedule = findById(id);
        if(schedule.getStatus().getCode().equals("CREATED")){
            schedule.setReviewedDate(LocalDateTime.now());
            //schedule.setReviewedUser();
            schedule.setStatus(statusService.getByCode("REVIEWED"));
            return schedule;
        }
        else {
            throw new UnsupportedOperationException("The status is not valid is: " + schedule.getStatus().getName());
        }
    }

    @Override
    public VacationSchedule approve(Long id) {
        var schedule = findById(id);
        if(schedule.getStatus().getCode().equals("REVIEWED")){
            schedule.setApprovedDate(LocalDateTime.now());
            //schedule.setApprovedUser();
            schedule.setStatus(statusService.getByCode("APPROVED"));
            return schedule;
        }
        else {
            throw new UnsupportedOperationException("The status  is not valid is: " + schedule.getStatus().getName());
        }
    }

}
