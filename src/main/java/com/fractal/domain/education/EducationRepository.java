package com.fractal.domain.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EducationRepository extends JpaRepository<Education,Long> {

}
