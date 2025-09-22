package com.fractal.domain.training_management.training.resource.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface TrainingResourceTypeRepository extends JpaRepository<TrainingResourceType,Long> {

    TrainingResourceType save(TrainingResourceType trainingResourceType);
    List<TrainingResourceType> findAll();
    Optional<TrainingResourceType> findByCode(String code);
    Optional<TrainingResourceType> findById(Long id);

}
