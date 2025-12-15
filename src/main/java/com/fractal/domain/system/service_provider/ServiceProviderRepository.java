package com.fractal.domain.system.service_provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
    Optional<ServiceProvider> findByCode(String code);

}
