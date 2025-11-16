package com.fractal.domain.learning_develpment.learning.instructor.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InternalInstructorRepository extends JpaRepository<InternalInstructor, Long> {

}
