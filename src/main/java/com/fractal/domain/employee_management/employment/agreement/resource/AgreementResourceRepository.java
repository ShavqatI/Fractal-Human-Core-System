package com.fractal.domain.employee_management.employment.agreement.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementResourceRepository extends JpaRepository<AgreementResource,Long> {

}
