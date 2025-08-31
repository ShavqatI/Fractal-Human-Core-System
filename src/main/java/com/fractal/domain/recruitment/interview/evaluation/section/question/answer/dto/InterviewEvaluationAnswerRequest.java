package com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record InterviewEvaluationAnswerRequest(
    String text,
    Long statusId
    )

{}
