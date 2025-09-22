package com.fractal.domain.training_management.training.participation.trainer.mapper;

import com.fractal.domain.training_management.training.participation.trainer.TrainerAssignment;
import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentRequest;
import com.fractal.domain.training_management.training.participation.trainer.dto.TrainerAssignmentResponse;

public interface TrainerAssignmentMapperService {
    TrainerAssignmentResponse toDTO(TrainerAssignment trainerAssignment);
    TrainerAssignment toEntity(TrainerAssignmentRequest dto);
    TrainerAssignment toEntity(TrainerAssignment trainerAssignment, TrainerAssignmentRequest dto);
}


