package com.fractal.domain.recruitment.candidate;

import com.fractal.domain.organization_management.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CandidateRepository extends JpaRepository<Candidate,Long> {

}
