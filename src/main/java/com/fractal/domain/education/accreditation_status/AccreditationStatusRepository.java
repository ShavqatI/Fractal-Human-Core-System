package com.fractal.domain.education.accreditation_status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface AccreditationStatusRepository extends JpaRepository<AccreditationStatus, Long> {
    Optional<AccreditationStatus> findById(Long id);

    Optional<AccreditationStatus> findByCode(String code);

    List<AccreditationStatus> findAll();
}
