package com.fractal.domain.learning_develpment.learning.session.location.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningLocationTypeRepository extends JpaRepository<LearningLocationType,Long> {

    LearningLocationType save(LearningLocationType learningLocationType);
    List<LearningLocationType> findAll();
    Optional<LearningLocationType> findByCode(String code);
    Optional<LearningLocationType> findById(Long id);

}
