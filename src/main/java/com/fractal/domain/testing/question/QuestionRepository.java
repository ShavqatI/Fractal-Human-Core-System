package com.fractal.domain.testing.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findAllByTestId(Long testId);
    Optional<Question> findByTestIdAndId(Long testId, Long id);
}
