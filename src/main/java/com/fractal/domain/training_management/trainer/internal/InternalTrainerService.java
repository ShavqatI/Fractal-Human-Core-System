package com.fractal.domain.training_management.trainer.internal;

import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerCompactResponse;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerRequest;
import com.fractal.domain.training_management.trainer.internal.dto.InternalTrainerResponse;

import java.util.List;

public interface InternalTrainerService {
    InternalTrainer create(InternalTrainerRequest dto);
    List<InternalTrainer> getAll();
    InternalTrainer getById(Long id);
    InternalTrainer update(Long id, InternalTrainerRequest dto);
    void deleteById(Long id);
    InternalTrainerResponse toDTO(InternalTrainer trainer);
    InternalTrainerCompactResponse toCompactDTO(InternalTrainer trainer);


}
