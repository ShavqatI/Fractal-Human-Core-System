package com.fractal.domain.interview.template.section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewTemplateSectionRepository extends JpaRepository<InterviewTemplateSection,Long> {

    List<InterviewTemplateSection> findAllByInterviewTemplateId(Long templateId);

    Optional<InterviewTemplateSection> findByInterviewTemplateIdAndId(Long templateId, Long id);
}
