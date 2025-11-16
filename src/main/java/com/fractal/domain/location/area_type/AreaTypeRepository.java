package com.fractal.domain.location.area_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface AreaTypeRepository extends JpaRepository<AreaType, Long> {
    Optional<AreaType> findById(Long id);

    Optional<AreaType> findByCode(String code);

    List<AreaType> findAll();
}
