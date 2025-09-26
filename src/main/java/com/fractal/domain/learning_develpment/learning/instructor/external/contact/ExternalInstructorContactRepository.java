package com.fractal.domain.learning_develpment.learning.instructor.external.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExternalInstructorContactRepository extends JpaRepository<ExternalInstructorContact,Long> {

    List<ExternalInstructorContact> findAllByExternalInstructorId(Long instructorId);
    Optional<ExternalInstructorContact> findByExternalInstructorIdAndId(Long instructorId, Long id);
}
