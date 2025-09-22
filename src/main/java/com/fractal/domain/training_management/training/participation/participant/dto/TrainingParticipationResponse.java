package com.fractal.domain.training_management.training.participation.participant.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.training_management.participant.dto.ParticipantCompactResponse;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record TrainingParticipationResponse(
        Long id,
        ParticipantCompactResponse participant,
        LocalTime startTime,
        LocalTime endTime,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }
