package com.fractal.domain.learning_develpment.learning.session.instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InstructorAssignmentRepository extends JpaRepository<InstructorAssignment,Long> {

    List<InstructorAssignment> findAllByLearningSessionId(Long sessionId);
    Optional<InstructorAssignment> findByLearningSessionIdAndId(Long sessionId, Long id);
}
