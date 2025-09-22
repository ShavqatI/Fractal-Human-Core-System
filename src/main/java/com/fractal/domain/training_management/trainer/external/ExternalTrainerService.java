package com.fractal.domain.training_management.trainer.external;

import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerRequest;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerResponse;

import java.util.List;

public interface ExternalTrainerService {
    ExternalTrainer create(ExternalTrainerRequest dto);
    List<ExternalTrainer> getAll();
    ExternalTrainer getById(Long id);
    ExternalTrainer update(Long id, ExternalTrainerRequest dto);
    void deleteById(Long id);
    ExternalTrainerResponse toDTO(ExternalTrainer trainer);
    ExternalTrainerCompactResponse toCompactDTO(ExternalTrainer trainer);
    ExternalTrainer save(ExternalTrainer trainer);


}
