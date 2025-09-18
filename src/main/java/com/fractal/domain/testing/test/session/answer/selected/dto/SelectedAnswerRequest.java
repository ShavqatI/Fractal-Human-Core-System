package com.fractal.domain.testing.test.session.answer.selected.dto;

import java.time.LocalDateTime;

public record SelectedAnswerRequest(
         Long answerId,
         LocalDateTime selectedDate

) {
}
