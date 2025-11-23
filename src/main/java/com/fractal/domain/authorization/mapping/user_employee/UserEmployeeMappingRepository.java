package com.fractal.domain.authorization.mapping.user_employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserEmployeeMappingRepository extends JpaRepository<UserEmployeeMapping, Long> {

    Optional<UserEmployeeMapping> findByUserId(Long userId);
}
