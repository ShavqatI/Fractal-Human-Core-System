package com.fractal.domain.learning_develpment.learning;

import com.fractal.domain.learning_develpment.learning.dto.LearningCompactResponse;
import com.fractal.domain.learning_develpment.learning.dto.LearningRequest;
import com.fractal.domain.learning_develpment.learning.dto.LearningResponse;
import com.fractal.domain.learning_develpment.learning.mapper.LearningMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class LearningServiceImpl implements LearningService {

    private final LearningRepository learningRepository;
    private final LearningMapperService mapperService;

    @Override
    @Transactional
    public Learning create(LearningRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Learning> getAll() {
        return learningRepository.findAll();
    }

    @Override
    public Learning getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Learning update(Long id, LearningRequest dto) {
        try {
            Learning learning = mapperService.toEntity(findById(id), dto);
            return save(learning);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        learningRepository.delete(findById(id));
    }

    @Override
    public LearningResponse toDTO(Learning learning) {
        return mapperService.toDTO(learning);
    }

    @Override
    public LearningCompactResponse toCompactDTO(Learning learning) {
        return mapperService.toCompactDTO(learning);
    }


    @Override
    @Transactional
    public Learning save(Learning learning) {
        try {
            return learningRepository.save(learning);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Learning findById(Long id) {
        return learningRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}

