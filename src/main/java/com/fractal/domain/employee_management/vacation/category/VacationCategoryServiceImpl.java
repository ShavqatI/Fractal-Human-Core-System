package com.fractal.domain.employee_management.vacation.category;

import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryRequest;
import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryResponse;
import com.fractal.domain.employee_management.vacation.type.VacationType;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeRequest;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationCategoryServiceImpl implements VacationCategoryService {

    private final VacationCategoryRepository vacationCategoryRepository;

    @Override
    public VacationCategory create(VacationCategoryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<VacationCategory> getAll() {
        return vacationCategoryRepository.findAll();
    }

    @Override
    public VacationCategory getByCode(String code) {
        return vacationCategoryRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Vacation Category with code: " + code + " not found"));

    }

    @Override
    public VacationCategory getById(Long id) {
        return findById(id);
    }

    @Override
    public VacationCategory update(Long id, VacationCategoryRequest dto) {
        try {
            VacationCategory vacationCategory = findById(id);
            vacationCategory.setCode(dto.code());
            vacationCategory.setName(dto.name());
            vacationCategory.setDescription(dto.description());
            return save(vacationCategory);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
       vacationCategoryRepository.delete(findById(id));
    }

    @Override
    public VacationCategoryResponse toDTO(VacationCategory vacationCategory) {
        return new VacationCategoryResponse(
                vacationCategory.getId(),
                vacationCategory.getCode(),
                vacationCategory.getName(),
                vacationCategory.getDescription(),
                vacationCategory.getCreatedDate()
        );
    }

    private VacationCategory toEntity(VacationCategoryRequest dto) {
        return VacationCategory.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    private VacationCategory save(VacationCategory vacationCategory) {
        try {
            return vacationCategoryRepository.save(vacationCategory);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationCategory findById(Long id) {
        return vacationCategoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Vacation Category with id: " + id + " not found"));
    }

}
