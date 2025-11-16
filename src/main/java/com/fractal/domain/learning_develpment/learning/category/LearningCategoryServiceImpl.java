package com.fractal.domain.learning_develpment.learning.category;

import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryCompactResponse;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryRequest;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryResponse;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;


@Service
@RequiredArgsConstructor
class LearningCategoryServiceImpl implements LearningCategoryService {

    private final LearningCategoryRepository learningCategoryRepository;

    @Override
    public LearningCategory create(LearningCategoryRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<LearningCategory> getAll() {
        return learningCategoryRepository.findAll();
    }

    @Override
    public LearningCategory getByCode(String code) {
        return learningCategoryRepository.findByCode(code).orElseThrow(() -> new ResourceWithCodeNotFoundException(this, code));
    }

    @Override
    public LearningCategory getById(Long id) {
        return findById(id);
    }

    @Override
    public LearningCategory update(Long id, LearningCategoryRequest dto) {
        try {
            LearningCategory learningCategory = findById(id);
            learningCategory.setCode(dto.code());
            learningCategory.setName(dto.name());
            learningCategory.setDescription(dto.description());
            return save(learningCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        learningCategoryRepository.delete(findById(id));
    }

    @Override
    public LearningCategoryResponse toDTO(LearningCategory learningCategory) {
        return new LearningCategoryResponse(
                learningCategory.getId(),
                learningCategory.getCode(),
                learningCategory.getName(),
                learningCategory.getDescription(),
                Optional.ofNullable(learningCategory.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                learningCategory.getCreatedDate()
        );
    }

    @Override
    public LearningCategoryCompactResponse toCompactDTO(LearningCategory learningCategory) {
        return new LearningCategoryCompactResponse(
                learningCategory.getId(),
                learningCategory.getCode(),
                learningCategory.getName()
        );
    }

    @Override
    public LearningCategory addChild(Long learningCategoryId, LearningCategoryRequest dto) {
        var category = findById(learningCategoryId);
        var child = toEntity(dto);
        category.addChild(child);
        return save(category);
    }

    @Override
    public LearningCategory updateChild(Long learningCategoryId, Long id, LearningCategoryRequest dto) {
        var category = findById(learningCategoryId);
        var child = category.getChildren().stream().filter(ch -> ch.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        update(child.getId(), dto);
        return save(category);
    }

    @Override
    public void deleteChild(Long learningCategoryId, Long id) {
        var category = findById(learningCategoryId);
        var child = category.getChildren().stream().filter(ch -> ch.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        category.removeChild(child);
        save(category);
    }

    private LearningCategory toEntity(LearningCategoryRequest dto) {
        var learningCategory = LearningCategory.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
        dto.children().forEach(child -> learningCategory.addChild(toEntity(child)));
        return learningCategory;
    }

    private LearningCategory save(LearningCategory learningCategory) {
        try {
            return learningCategoryRepository.save(learningCategory);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LearningCategory findById(Long id) {
        return learningCategoryRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
