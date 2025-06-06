package com.fractal.domain.employee_management.education.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationResourceRepository extends JpaRepository<EducationResource,Long> {

}
