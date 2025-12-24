package com.fractal.domain.authorization.mapping.user_candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface UserCandidateMappingRepository extends JpaRepository<UserCandidateMapping, Long> {
    List<UserCandidateMapping> findByUserId(Long id);
}
