package com.fractal.domain.employment.punishment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface PunishmentRepository extends JpaRepository<Punishment, Long> {
    List<Punishment> findAllByEmploymentId(Long employmentId);

    Optional<Punishment> findByEmploymentIdAndId(Long employmentId, Long id);


}
