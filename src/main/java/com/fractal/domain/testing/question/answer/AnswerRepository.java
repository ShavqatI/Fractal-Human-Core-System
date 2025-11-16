package com.fractal.domain.testing.question.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllByQuestionId(Long questionId);

    Optional<Answer> findByQuestionIdAndId(Long questionId, Long id);
}
