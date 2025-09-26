package com.fractal.domain.learning_develpment.learning.session.location.offline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OfflineLearningLocationRepository extends JpaRepository<OfflineLearningLocation,Long> {

  List<OfflineLearningLocation> findAllByLearningSessionId(Long sessionId);
  Optional<OfflineLearningLocation> findByLearningSessionIdAndId(Long sessionId, Long id);

}
