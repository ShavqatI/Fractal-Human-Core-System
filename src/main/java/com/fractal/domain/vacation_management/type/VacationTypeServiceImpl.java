package com.fractal.domain.vacation_management.type;

import com.fractal.domain.vacation_management.type.dto.VacationTypeRequest;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationTypeServiceImpl implements VacationTypeService {

    private final VacationTypeRepository vacationTypeRepository;

    @Override
    public VacationType create(VacationTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<VacationType> getAll() {
        return vacationTypeRepository.findAll();
    }

    @Override
    public VacationType getByCode(String code) {
        return vacationTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with code: " + code + " not found"));

    }

    @Override
    public VacationType getById(Long id) {
        return findById(id);
    }

    @Override
    public VacationType update(Long id, VacationTypeRequest dto) {
        try {
            VacationType vacationType = findById(id);
            vacationType.setCode(dto.code());
            vacationType.setName(dto.name());
            vacationType.setDescription(dto.description());
            vacationType.setDays(dto.days());
            return save(vacationType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        vacationTypeRepository.delete(findById(id));
    }

    @Override
    public VacationTypeResponse toDTO(VacationType vacationType) {
        return new VacationTypeResponse(
                vacationType.getId(),
                vacationType.getCode(),
                vacationType.getName(),
                vacationType.getDescription(),
                vacationType.getDays(),
                vacationType.getCreatedDate()
        );
    }

    private VacationType toEntity(VacationTypeRequest dto) {
        return VacationType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .days(dto.days())
                .build();
    }

    private VacationType save(VacationType vacationType) {
        try {
            return vacationTypeRepository.save(vacationType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationType findById(Long id) {
        return vacationTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with id: " + id + " not found"));
    }

}
