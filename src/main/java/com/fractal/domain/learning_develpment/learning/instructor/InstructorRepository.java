package com.fractal.domain.learning_develpment.learning.instructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InstructorRepository extends JpaRepository<Instructor,Long> {

}
