package com.fractal.domain.training_management.training.location.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface TrainingLocationTypeRepository extends JpaRepository<TrainingLocationType,Long> {

    TrainingLocationType save(TrainingLocationType trainingLocationType);
    List<TrainingLocationType> findAll();
    Optional<TrainingLocationType> findByCode(String code);
    Optional<TrainingLocationType> findById(Long id);

}
