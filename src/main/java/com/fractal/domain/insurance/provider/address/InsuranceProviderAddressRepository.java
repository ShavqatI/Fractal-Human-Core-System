package com.fractal.domain.insurance.provider.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InsuranceProviderAddressRepository extends JpaRepository<InsuranceProviderAddress, Long> {
    List<InsuranceProviderAddress> findAllByInsuranceProviderId(Long insuranceProviderId);
    Optional<InsuranceProviderAddress> findByInsuranceProviderIdAndId(Long insuranceProviderId, Long id);
}
