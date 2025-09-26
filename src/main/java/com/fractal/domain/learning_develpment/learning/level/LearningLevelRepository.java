package com.fractal.domain.learning_develpment.learning.level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningLevelRepository extends JpaRepository<LearningLevel,Long> {
    Optional<LearningLevel> findById(Long id);
    Optional<LearningLevel> findByCode(String code);
    List<LearningLevel> findAll();
}
