package com.fractal.domain.interview.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewTypeRepository extends JpaRepository<InterviewType, Long> {
    Optional<InterviewType> findById(Long id);

    Optional<InterviewType> findByCode(String code);

    List<InterviewType> findAll();
}
