package com.fractal.domain.organization_management.job_description.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    List<Authority> findAllByJobDescriptionId(Long jobDescriptionId);

    Optional<Authority> findByJobDescriptionIdAndId(Long jobDescriptionId, Long id);
}
