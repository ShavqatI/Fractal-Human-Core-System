package com.fractal.domain.employee_management.relative.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RelativeAddressRepository extends JpaRepository<RelativeAddress, Long> {
}
