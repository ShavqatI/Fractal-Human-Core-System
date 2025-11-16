package com.fractal.domain.learning_develpment.learning.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningCategoryRepository extends JpaRepository<LearningCategory, Long> {
    Optional<LearningCategory> findById(Long id);

    Optional<LearningCategory> findByCode(String code);

    List<LearningCategory> findAll();
}
