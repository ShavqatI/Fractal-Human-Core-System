package com.fractal.domain.agreement.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgreementResourceRepository extends JpaRepository<AgreementResource, Long> {
    List<AgreementResource> findAllByAgreementId(Long agreementId);

    Optional<AgreementResource> findByAgreementIdAndId(Long agreementId, Long id);
}
