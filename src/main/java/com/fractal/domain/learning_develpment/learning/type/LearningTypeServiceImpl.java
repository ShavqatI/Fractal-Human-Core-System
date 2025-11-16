package com.fractal.domain.learning_develpment.learning.type;

import com.fractal.domain.learning_develpment.learning.type.dto.LearningTypeRequest;
import com.fractal.domain.learning_develpment.learning.type.dto.LearningTypeResponse;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class LearningTypeServiceImpl implements LearningTypeService {

    private final LearningTypeRepository learningTypeRepository;

    @Override
    public LearningType create(LearningTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<LearningType> getAll() {
        return learningTypeRepository.findAll();
    }

    @Override
    public LearningType getByCode(String code) {
        return learningTypeRepository.findByCode(code).orElseThrow(() -> new ResourceWithCodeNotFoundException(this, code));
    }

    @Override
    public LearningType getById(Long id) {
        return findById(id);
    }

    @Override
    public LearningType update(Long id, LearningTypeRequest dto) {
        try {
            LearningType learningType = findById(id);
            learningType.setCode(dto.code());
            learningType.setName(dto.name());
            return save(learningType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        learningTypeRepository.delete(findById(id));
    }

    @Override
    public LearningTypeResponse toDTO(LearningType learningType) {
        return new LearningTypeResponse(
                learningType.getId(),
                learningType.getCode(),
                learningType.getName(),
                learningType.getCreatedDate()
        );
    }

    private LearningType toEntity(LearningTypeRequest dto) {
        return LearningType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private LearningType save(LearningType learningType) {
        try {
            return learningTypeRepository.save(learningType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LearningType findById(Long id) {
        return learningTypeRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

}
