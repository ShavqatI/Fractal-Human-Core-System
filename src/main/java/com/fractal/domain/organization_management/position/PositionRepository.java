package com.fractal.domain.organization_management.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface PositionRepository extends JpaRepository<Position,Long> {

    Position save(Position position);
    List<Position> findAll();
    Optional<Position> findByCode(String code);
    Optional<Position> findById(Long id);

}
