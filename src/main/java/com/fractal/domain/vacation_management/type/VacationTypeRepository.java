package com.fractal.domain.vacation_management.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface VacationTypeRepository extends JpaRepository<VacationType, Long> {
    Optional<VacationType> findByCode(String code);

}
