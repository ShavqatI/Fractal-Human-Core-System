package com.fractal.domain.testing.test.session.answer.selected;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface SelectedAnswerRepository extends JpaRepository<SelectedAnswer, Long> {

    List<SelectedAnswer> findAllByAnswerSubmissionId(Long submissionId);

    Optional<SelectedAnswer> findByAnswerSubmissionIdAndId(Long submissionId, Long id);
}
