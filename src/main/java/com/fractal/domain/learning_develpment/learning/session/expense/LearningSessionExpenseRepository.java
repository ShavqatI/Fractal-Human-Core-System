package com.fractal.domain.learning_develpment.learning.session.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningSessionExpenseRepository extends JpaRepository<LearningSessionExpense, Long> {

    List<LearningSessionExpense> findAllByLearningSessionId(Long sessionId);

    Optional<LearningSessionExpense> findByLearningSessionIdAndId(Long sessionId, Long id);

}
