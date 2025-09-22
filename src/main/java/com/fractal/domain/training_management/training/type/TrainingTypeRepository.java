package com.fractal.domain.training_management.training.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface TrainingTypeRepository extends JpaRepository<TrainingType,Long> {

    TrainingType save(TrainingType trainingType);
    List<TrainingType> findAll();
    Optional<TrainingType> findByCode(String code);
    Optional<TrainingType> findById(Long id);

}
