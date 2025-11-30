package com.fractal.domain.employment.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface InternalEmploymentRepository extends JpaRepository<InternalEmployment, Long> {

    List<InternalEmployment> findAllByStatusCode(String statusCode);
}
