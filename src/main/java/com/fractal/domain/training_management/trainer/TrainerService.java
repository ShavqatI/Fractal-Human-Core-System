package com.fractal.domain.training_management.trainer;

import com.fractal.domain.testing.test.Test;
import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;
import com.fractal.domain.training_management.training.Training;

import java.util.List;

public interface TrainerService {
    Trainer getById(Long id);
    TrainerCompactResponse toCompactDTO(Trainer trainer);
}
