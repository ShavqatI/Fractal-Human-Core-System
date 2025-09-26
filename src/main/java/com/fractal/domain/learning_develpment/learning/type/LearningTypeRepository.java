package com.fractal.domain.learning_develpment.learning.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningTypeRepository extends JpaRepository<LearningType,Long> {
    Optional<LearningType> findById(Long id);
    Optional<LearningType> findByCode(String code);
    List<LearningType> findAll();
}
