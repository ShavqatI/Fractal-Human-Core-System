package com.fractal.domain.learning_develpment.learning.delivery_mode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningDeliveryModeRepository extends JpaRepository<LearningDeliveryMode, Long> {
    Optional<LearningDeliveryMode> findById(Long id);

    Optional<LearningDeliveryMode> findByCode(String code);

    List<LearningDeliveryMode> findAll();
}
