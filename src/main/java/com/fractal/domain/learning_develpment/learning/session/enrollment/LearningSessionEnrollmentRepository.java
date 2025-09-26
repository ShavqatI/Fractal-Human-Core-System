package com.fractal.domain.learning_develpment.learning.session.enrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface LearningSessionEnrollmentRepository extends JpaRepository<LearningSessionEnrollment,Long> {

    List<LearningSessionEnrollment> findAllByLearningSessionId(Long sessionId);
    Optional<LearningSessionEnrollment> findByLearningSessionIdAndId(Long sessionId, Long id);
}
