package com.fractal.domain.learning_develpment.learning.session.instructor.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InstructorAssignmentTypeRepository extends JpaRepository<InstructorAssignmentType,Long> {
    Optional<InstructorAssignmentType> findById(Long id);
    Optional<InstructorAssignmentType> findByCode(String code);
    List<InstructorAssignmentType> findAll();
}
