package com.fractal.domain.learning_develpment.learning.session.location.offline.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OfflineLearningLocationAddressRepository extends JpaRepository<OfflineLearningLocationAddress, Long> {
    List<OfflineLearningLocationAddress> findAllByOfflineLearningLocationId(Long locationId);

    Optional<OfflineLearningLocationAddress> findByOfflineLearningLocationIdAndId(Long locationId, Long id);
}
