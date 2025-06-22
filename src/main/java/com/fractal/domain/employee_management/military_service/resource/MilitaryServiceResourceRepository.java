package com.fractal.domain.employee_management.military_service.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MilitaryServiceResourceRepository extends JpaRepository<MilitaryServiceResource,Long> {

    List<MilitaryServiceResource> findAllByMilitaryServiceId(Long militaryServiceId);
    Optional<MilitaryServiceResource> findByMilitaryServiceIdAndId(Long militaryServiceId, Long id);

}
