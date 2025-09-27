package com.fractal.domain.interview.template.section.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewTemplateQuestionRepository extends JpaRepository<InterviewTemplateQuestion,Long> {

    List<InterviewTemplateQuestion> findAllByInterviewTemplateSectionId(Long sectionId);

    Optional<InterviewTemplateQuestion> findByInterviewTemplateSectionIdAndId(Long sectionId, Long id);
}
