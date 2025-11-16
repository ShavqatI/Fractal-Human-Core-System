package com.fractal.domain.education.grade_point_average;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface GradePointAverageRepository extends JpaRepository<GradePointAverage, Long> {
    Optional<GradePointAverage> findById(Long id);

    List<GradePointAverage> findAll();
}
