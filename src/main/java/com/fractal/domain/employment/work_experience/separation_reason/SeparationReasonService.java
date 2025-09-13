package com.fractal.domain.employment.work_experience.separation_reason;

import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonCompactResponse;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.InterviewEvaluationAnswer;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;

import java.util.List;

public interface SeparationReasonService {
    SeparationReason create(Long workExperienceId, SeparationReasonRequest dto);
    List<SeparationReason> getAllByWorkExperienceId(Long workExperienceId);
    SeparationReason getById(Long workExperienceId , Long id);
    SeparationReason update(Long workExperienceId, Long id,SeparationReasonRequest dto);
    void delete(Long workExperienceId, Long id);
    SeparationReasonResponse toDTO(SeparationReason separationReason);
}
