package com.fractal.domain.training_management.training.participation.trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface TrainerAssignmentRepository extends JpaRepository<TrainerAssignment,Long> {

    List<TrainerAssignment> findAllByTrainingId(Long trainingId);
    Optional<TrainerAssignment> findByTrainingIdAndId(Long trainingId, Long id);
}
