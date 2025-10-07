package com.fractal.domain.employment.internal.agreement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InternalEmploymentAgreementRepository extends JpaRepository<InternalEmploymentAgreement,Long> {

    List<InternalEmploymentAgreement> findAllByInternalEmploymentId(Long employmentId);
    Optional<InternalEmploymentAgreement> findByInternalEmploymentIdAndId(Long employmentId, Long id);
}
