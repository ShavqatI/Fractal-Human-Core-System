package com.fractal.domain.training_management.training.location.offline.external.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface ExternalTrainingLocationAddressRepository extends JpaRepository<ExternalTrainingLocationAddress, Long> {
    List<ExternalTrainingLocationAddress> findAllByExternalTrainingLocationId(Long locationId);
    Optional<ExternalTrainingLocationAddress> findByExternalTrainingLocationIdAndId(Long locationId, Long id);
}
