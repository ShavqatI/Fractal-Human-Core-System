package com.fractal.domain.learning_develpment.learning.session.resource.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningSessionResourceTypeRepository extends JpaRepository<LearningSessionResourceType,Long> {

    LearningSessionResourceType save(LearningSessionResourceType learningSessionResourceType);
    List<LearningSessionResourceType> findAll();
    Optional<LearningSessionResourceType> findByCode(String code);
    Optional<LearningSessionResourceType> findById(Long id);

}
