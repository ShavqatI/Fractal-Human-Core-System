package com.fractal.domain.training_management.training.participation.participant.dto;

import java.time.LocalTime;

public record TrainingParticipationRequest(
        Long participantId,
        LocalTime startTime,
        LocalTime endTime,
        Long statusId

) { }
