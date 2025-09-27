package com.fractal.domain.interview.template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InterviewTemplateRepository extends JpaRepository<InterviewTemplate,Long> {

}
