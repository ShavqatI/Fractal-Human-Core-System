package com.fractal.domain.employment.internal.agreement.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InternalEmploymentAgreementResourceRepository extends JpaRepository<InternalEmploymentAgreementResource,Long> {

    List<InternalEmploymentAgreementResource> findAllByInternalEmploymentAgreementId(Long agreementId);
    Optional<InternalEmploymentAgreementResource> findByInternalEmploymentAgreementIdAndId(Long agreementId, Long id);

}
