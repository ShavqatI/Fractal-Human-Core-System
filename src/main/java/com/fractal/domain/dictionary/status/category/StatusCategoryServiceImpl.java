package com.fractal.domain.dictionary.status.category;

import com.fractal.domain.dictionary.status.category.dto.StatusCategoryRequest;
import com.fractal.domain.dictionary.status.category.dto.StatusCategoryResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class StatusCategoryServiceImpl implements StatusCategoryService {

    private final StatusCategoryRepository statusCategoryRepository;

    @Override
    public StatusCategory create(StatusCategoryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<StatusCategory> getAll() {
        return statusCategoryRepository.findAll();
    }

    @Override
    public StatusCategory getByCode(String code) {
        return statusCategoryRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Status Category with code: " + code + " not found"));

    }

    @Override
    public StatusCategory getById(Long id) {
        return findById(id);
    }

    @Override
    public StatusCategory update(Long id, StatusCategoryRequest dto) {
        try {
            StatusCategory statusCategory = findById(id);
            statusCategory.setCode(dto.code());
            statusCategory.setName(dto.name());
            return save(statusCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        statusCategoryRepository.delete(findById(id));
    }

    @Override
    public StatusCategoryResponse toDTO(StatusCategory statusCategory) {
        return new StatusCategoryResponse(
                statusCategory.getId(),
                statusCategory.getCode(),
                statusCategory.getName(),
                statusCategory.getCreatedDate()
        );
    }


    private StatusCategory toEntity(StatusCategoryRequest dto) {
        return StatusCategory.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private StatusCategory save(StatusCategory statusCategory) {
        try {
            return statusCategoryRepository.save(statusCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private StatusCategory findById(Long id) {
        return statusCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Status Category with id: " + id + " not found"));
    }

}
