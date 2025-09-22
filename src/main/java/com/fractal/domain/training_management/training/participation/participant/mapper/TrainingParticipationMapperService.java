package com.fractal.domain.training_management.training.participation.participant.mapper;

import com.fractal.domain.training_management.training.participation.participant.TrainingParticipation;
import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationRequest;
import com.fractal.domain.training_management.training.participation.participant.dto.TrainingParticipationResponse;

public interface TrainingParticipationMapperService {
    TrainingParticipationResponse toDTO(TrainingParticipation trainingParticipation);
    TrainingParticipation toEntity(TrainingParticipationRequest dto);
    TrainingParticipation toEntity(TrainingParticipation trainingParticipation, TrainingParticipationRequest dto);
}


