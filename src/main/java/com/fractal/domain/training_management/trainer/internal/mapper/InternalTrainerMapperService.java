package com.fractal.domain.training_management.trainer.internal.mapper;

import com.fractal.domain.training_management.trainer.Trainer;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;
import com.fractal.domain.training_management.trainer.internal.InternalTrainer;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerRequest;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerResponse;

public interface InternalTrainerMapperService {
    InternalTrainerResponse toDTO(InternalTrainer trainer);
    InternalTrainerCompactResponse toCompactDTO(InternalTrainer trainer);
    TrainerCompactResponse toCompactDTO(Trainer trainer);
    InternalTrainer toEntity(InternalTrainerRequest dto);
    InternalTrainer toEntity(InternalTrainer trainer, InternalTrainerRequest dto);
}


