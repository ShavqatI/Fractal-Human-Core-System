package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.organization_management.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface JobDescriptionRepository extends JpaRepository<JobDescription,Long> {

    JobDescription save(JobDescription jobDescription);
    List<JobDescription> findAll();
    Optional<JobDescription> findById(Long id);

}
