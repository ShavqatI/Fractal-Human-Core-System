package com.fractal.domain.employee_management.employment.agreement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AgreementRepository extends JpaRepository<Agreement,Long> {
}
