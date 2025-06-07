package com.fractal.domain.employee_management.military_service.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilitaryServiceResourceRepository extends JpaRepository<MilitaryServiceResource,Long> {

}
