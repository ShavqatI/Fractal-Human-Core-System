package com.fractal.domain.testing.test.session.answer.mapper;

import com.fractal.domain.testing.test.session.answer.AnswerSubmission;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionRequest;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionResponse;

public interface AnswerSubmissionMapperService {
    AnswerSubmissionResponse toDTO(AnswerSubmission submission);

    AnswerSubmission toEntity(AnswerSubmissionRequest dto);

    AnswerSubmission toEntity(AnswerSubmission submission, AnswerSubmissionRequest dto);
}


