package com.fractal.domain.vacation_management.vacation;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.vacation.dto.VacationRequest;
import com.fractal.domain.vacation_management.vacation.dto.VacationResponse;
import com.fractal.domain.vacation_management.vacation.mapper.VacationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class VacationServiceImpl implements VacationService {

    private final VacationRepository vacationRepository;
    private final VacationMapperService mapperService;


    @Override
    public Vacation create(VacationRequest dto) {
        var vacation = save(mapperService.toEntity(dto));
        return vacation;
    }

    @Override
    public List<Vacation> getAll() {
        return vacationRepository.findAll();
    }

    @Override
    public Vacation getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Vacation> getAllByEmployeeId(Long employeeId) {
        return vacationRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public Vacation update(Long id, VacationRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id), dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        vacationRepository.delete(findById(id));
    }

    public VacationResponse toDTO(Vacation vacation) {
        return mapperService.toDTO(vacation);
    }

    @Override
    public Vacation save(Vacation vacation) {
        try {
            return vacationRepository.save(vacation);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Vacation findById(Long id) {
        return vacationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation with id: " + id + " not found"));
    }

}
