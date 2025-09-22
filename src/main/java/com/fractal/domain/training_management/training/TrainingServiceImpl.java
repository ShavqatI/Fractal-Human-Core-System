
package com.fractal.domain.training_management.training;

import com.fractal.domain.testing.test.Test;
import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;
import com.fractal.domain.testing.test.mapper.TestMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final TestMapperService mapperService;

    @Override
    @Transactional
    public Training create(TestRequest dto) {
        return null;//return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Training> getAll() {
        return trainingRepository.findAll();
    }

    @Override
    public Training getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Training update(Long id, TestRequest dto) {
       /* try {
            Test test = mapperService.toEntity(findById(id),dto);
            return save(test);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }*/
      return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      trainingRepository.delete(findById(id));
    }

    @Override
    public TestResponse toDTO(Test test) {
        return mapperService.toDTO(test);
    }

    @Override
    public TestCompactResponse toCompactDTO(Test test) {
        return mapperService.toCompactDTO(test);
    }


    @Override
    @Transactional
    public Training save(Training test) {
        try {
            return trainingRepository.save(test);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Training findById(Long id) {
        return trainingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Training with id: " + id + " not found"));
    }
}

