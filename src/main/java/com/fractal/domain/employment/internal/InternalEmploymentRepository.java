package com.fractal.domain.employment.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InternalEmploymentRepository extends JpaRepository<InternalEmployment, Long> {

    List<InternalEmployment> findAllByStatusCode(String statusCode);

    @Query("""
    select ie from InternalEmployment ie
    join ie.compensationComponents cc
    where cc.id = :compensationId
    """)
    Optional<InternalEmployment> findCompensationComponentId(Long compensationId);
}
