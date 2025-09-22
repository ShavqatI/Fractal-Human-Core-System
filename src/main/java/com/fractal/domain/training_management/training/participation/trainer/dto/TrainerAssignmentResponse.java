package com.fractal.domain.training_management.training.participation.trainer.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.testing.question.answer.dto.AnswerResponse;
import com.fractal.domain.testing.question.type.dto.QuestionTypeResponse;
import com.fractal.domain.training_management.trainer.Trainer;
import com.fractal.domain.training_management.trainer.dto.TrainerCompactResponse;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record TrainerAssignmentResponse(
        Long id,

        TrainerCompactResponse trainer,
        LocalTime startTime,
        LocalTime endTime,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }
