package com.fractal.domain.organization_management.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface PositionRepository extends JpaRepository<Position, Long> {

    Optional<Position> findByCode(String code);

    Optional<Position> findFirstByOrderByIdDesc();


}
