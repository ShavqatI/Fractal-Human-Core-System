package com.fractal.domain.learning_develpment.learning.instructor.external;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExternalInstructorRepository extends JpaRepository<ExternalInstructor,Long> {

}
