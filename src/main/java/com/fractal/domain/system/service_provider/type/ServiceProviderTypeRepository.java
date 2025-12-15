package com.fractal.domain.system.service_provider.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ServiceProviderTypeRepository extends JpaRepository<ServiceProviderType, Long> {
    Optional<ServiceProviderType> findByCode(String code);

}
