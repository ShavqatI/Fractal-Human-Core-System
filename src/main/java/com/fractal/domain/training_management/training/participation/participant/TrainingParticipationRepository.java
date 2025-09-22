package com.fractal.domain.training_management.training.participation.participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface TrainingParticipationRepository extends JpaRepository<TrainingParticipation,Long> {

    List<TrainingParticipation> findAllByTrainingId(Long trainingId);
    Optional<TrainingParticipation> findByTrainingIdAndId(Long trainingId, Long id);
}
