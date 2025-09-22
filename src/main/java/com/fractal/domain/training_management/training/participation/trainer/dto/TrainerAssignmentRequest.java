package com.fractal.domain.training_management.training.participation.trainer.dto;

import com.fractal.domain.training_management.trainer.Trainer;

import java.time.LocalTime;

public record TrainerAssignmentRequest(
        Long trainerId,
        LocalTime startTime,
        LocalTime endTime,
        Long statusId

) { }
