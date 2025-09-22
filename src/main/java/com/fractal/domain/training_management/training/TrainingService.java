package com.fractal.domain.training_management.training;

import com.fractal.domain.testing.test.Test;
import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;

import java.util.List;

public interface TrainingService {
    Training create(TestRequest dto);
    List<Training> getAll();
    Training getById(Long id);
    Training update(Long id, TestRequest dto);
    void deleteById(Long id);
    TestResponse toDTO(Test test);
    TestCompactResponse toCompactDTO(Test test);
    Training save(Training training);


}
