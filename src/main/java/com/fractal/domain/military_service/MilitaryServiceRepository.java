package com.fractal.domain.military_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MilitaryServiceRepository extends JpaRepository<MilitaryService,Long> {
}
