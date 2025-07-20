package com.fractal.domain.authorization.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("""
    SELECT ur FROM UserRole ur
    JOIN FETCH ur.role
    JOIN FETCH ur.status
    WHERE ur.user.id = :userId
""")
    List<UserRole> findAllWithRoleAndStatusByUserId(@Param("userId") Long userId);
    List<UserRole> findAllByUserId(Long userId);
}
