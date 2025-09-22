package com.fractal.domain.training_management.training.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingResourceRepository extends JpaRepository<TrainingResource,Long> {
    List<TrainingResource> findAllByTrainingId(Long trainingId);
    Optional<TrainingResource> findByTrainingIdAndId(Long trainingId, Long id);
}
