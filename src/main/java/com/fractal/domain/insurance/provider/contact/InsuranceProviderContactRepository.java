package com.fractal.domain.insurance.provider.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceProviderContactRepository extends JpaRepository<InsuranceProviderContact,Long> {

    List<InsuranceProviderContact> findAllByInsuranceProviderId(Long insuranceProviderId);
    Optional<InsuranceProviderContact> findByInsuranceProviderIdAndId(Long insuranceProviderId, Long id);
}
