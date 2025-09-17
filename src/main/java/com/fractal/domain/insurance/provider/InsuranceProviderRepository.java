package com.fractal.domain.insurance.provider;

import com.fractal.domain.recruitment.candidate.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InsuranceProviderRepository extends JpaRepository<InsuranceProvider,Long> {

}
