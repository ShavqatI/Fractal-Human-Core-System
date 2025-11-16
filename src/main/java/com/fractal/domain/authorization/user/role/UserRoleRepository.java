package com.fractal.domain.authorization.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findAllByUserId(Long userId);
}
