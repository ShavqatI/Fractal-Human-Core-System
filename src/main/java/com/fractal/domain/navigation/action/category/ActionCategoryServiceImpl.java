package com.fractal.domain.navigation.action.category;

import com.fractal.domain.navigation.action.category.dto.ActionCategoryRequest;
import com.fractal.domain.navigation.action.category.dto.ActionCategoryResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ActionCategoryServiceImpl implements ActionCategoryService {

    private final ActionCategoryRepository actionCategoryRepository;

    @Override
    public ActionCategory create(ActionCategoryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<ActionCategory> getAll() {
        return actionCategoryRepository.findAll();
    }

    @Override
    public ActionCategory getByCode(String code) {
        return actionCategoryRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Action Category with code: " + code + " not found"));
    }

    @Override
    public ActionCategory getById(Long id) {
        return findById(id);
    }

    @Override
    public ActionCategory update(Long id, ActionCategoryRequest dto) {
        try {
            ActionCategory actionCategory = findById(id);
            actionCategory.setCode(dto.code());
            actionCategory.setName(dto.name());
            return save(actionCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        actionCategoryRepository.delete(findById(id));
    }

    @Override
    public ActionCategoryResponse toDTO(ActionCategory actionCategory) {
        return new ActionCategoryResponse(
                actionCategory.getId(),
                actionCategory.getCode(),
                actionCategory.getName(),
                actionCategory.getCreatedDate()
        );
    }

    private ActionCategory toEntity(ActionCategoryRequest dto) {
        return ActionCategory.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private ActionCategory save(ActionCategory actionCategory) {
        try {
            return actionCategoryRepository.save(actionCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private ActionCategory findById(Long id) {
        return actionCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Action Category with id: " + id + " not found"));
    }

}
