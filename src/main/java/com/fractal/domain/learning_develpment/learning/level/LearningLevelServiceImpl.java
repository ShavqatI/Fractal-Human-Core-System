package com.fractal.domain.learning_develpment.learning.level;

import com.fractal.domain.learning_develpment.learning.level.dto.LearningLevelRequest;
import com.fractal.domain.learning_develpment.learning.level.dto.LearningLevelResponse;
import com.fractal.exception.ResourceWithCodeNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class LearningLevelServiceImpl implements LearningLevelService {

    private final LearningLevelRepository learningLevelRepository;

    @Override
    public LearningLevel create(LearningLevelRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<LearningLevel> getAll() {
        return learningLevelRepository.findAll();
    }

    @Override
    public LearningLevel getByCode(String code) {
        return learningLevelRepository.findByCode(code).orElseThrow(()-> new ResourceWithCodeNotFoundException(this,code));
    }

    @Override
    public LearningLevel getById(Long id) {
        return findById(id);
    }

    @Override
    public LearningLevel update(Long id, LearningLevelRequest dto) {
        try {
            LearningLevel learningLevel = findById(id);
            learningLevel.setCode(dto.code());
            learningLevel.setName(dto.name());
            return save(learningLevel);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      learningLevelRepository.delete(findById(id));
    }

    @Override
    public LearningLevelResponse toDTO(LearningLevel learningLevel) {
        return new LearningLevelResponse(
                learningLevel.getId(),
                learningLevel.getCode(),
                learningLevel.getName(),
                learningLevel.getCreatedDate()
        );
    }

    private LearningLevel toEntity(LearningLevelRequest dto) {
        return LearningLevel.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private LearningLevel save(LearningLevel learningLevel) {
        try {
            return learningLevelRepository.save(learningLevel);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LearningLevel findById(Long id) {
        return learningLevelRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

}
