package com.fractal.domain.authorization.user;

import com.fractal.domain.employee_management.address.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
