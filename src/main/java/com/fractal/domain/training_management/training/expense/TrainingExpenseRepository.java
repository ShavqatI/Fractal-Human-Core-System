package com.fractal.domain.training_management.training.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface TrainingExpenseRepository extends JpaRepository<TrainingExpense,Long> {

  List<TrainingExpense> findAllByTrainingId(Long trainerId);
  Optional<TrainingExpense> findByTrainingIdAndId(Long trainerId, Long id);

}
