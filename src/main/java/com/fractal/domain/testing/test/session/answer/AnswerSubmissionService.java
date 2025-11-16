package com.fractal.domain.testing.test.session.answer;


import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionRequest;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionResponse;

import java.util.List;

public interface AnswerSubmissionService {

    AnswerSubmission create(Long testSessionId, AnswerSubmissionRequest dto);

    List<AnswerSubmission> getAllBySessionId(Long testSessionId);

    AnswerSubmission getById(Long testSessionId, Long id);

    AnswerSubmission getById(Long id);

    AnswerSubmissionResponse toDTO(AnswerSubmission submission);

    AnswerSubmission update(Long testSessionId, Long id, AnswerSubmissionRequest dto);

    void delete(Long testId, Long id);

    AnswerSubmission save(AnswerSubmission submission);

}
