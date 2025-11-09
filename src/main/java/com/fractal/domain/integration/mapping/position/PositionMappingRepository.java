package com.fractal.domain.integration.mapping.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PositionMappingRepository extends JpaRepository<PositionMapping,Long> {

}
