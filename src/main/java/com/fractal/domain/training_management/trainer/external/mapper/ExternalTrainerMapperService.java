package com.fractal.domain.training_management.trainer.external.mapper;

import com.fractal.domain.training_management.trainer.Trainer;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;
import com.fractal.domain.training_management.trainer.external.ExternalTrainer;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerRequest;
import com.fractal.domain.training_management.trainer.external.dto.ExternalTrainerResponse;

public interface ExternalTrainerMapperService {
    ExternalTrainerResponse toDTO(ExternalTrainer trainer);
    ExternalTrainerCompactResponse toCompactDTO(ExternalTrainer trainer);
    TrainerCompactResponse toCompactDTO(Trainer trainer);
    ExternalTrainer toEntity(ExternalTrainerRequest dto);
    ExternalTrainer toEntity(ExternalTrainer trainer, ExternalTrainerRequest dto);
}


