package com.fractal.domain.employment.punishment.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface PunishmentTypeRepository extends JpaRepository<PunishmentType, Long> {
    Optional<PunishmentType> findById(Long id);

    Optional<PunishmentType> findByCode(String code);

    List<PunishmentType> findAll();
}
