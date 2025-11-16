package com.fractal.domain.learning_develpment.learning.session.location.online;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OnlineLearningLocationRepository extends JpaRepository<OnlineLearningLocation, Long> {

    List<OnlineLearningLocation> findAllByLearningSessionId(Long sessionId);

    Optional<OnlineLearningLocation> findByLearningSessionIdAndId(Long sessionId, Long id);

}
