package com.fractal.domain.testing.test.session.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface AnswerSubmissionRepository extends JpaRepository<AnswerSubmission,Long> {

    List<AnswerSubmission> findAllByTestSessionId(Long testSessionId);
    Optional<AnswerSubmission> findByTestSessionIdAndId(Long testSessionId, Long id);
}
