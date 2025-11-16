package com.fractal.domain.learning_develpment.learning.session.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearningSessionResourceRepository extends JpaRepository<LearningSessionResource, Long> {
    List<LearningSessionResource> findAllByLearningSessionId(Long learningSessionId);

    Optional<LearningSessionResource> findByLearningSessionIdAndId(Long learningSessionId, Long id);
}
