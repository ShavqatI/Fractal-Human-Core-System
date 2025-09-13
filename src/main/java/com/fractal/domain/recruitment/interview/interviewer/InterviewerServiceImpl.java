package com.fractal.domain.recruitment.interview.interviewer;

import com.fractal.domain.recruitment.interview.evaluation.session.InterviewEvaluationSession;
import com.fractal.domain.recruitment.interview.evaluation.session.dto.InterviewEvaluationSessionResponse;
import com.fractal.domain.recruitment.interview.interviewer.dto.InterviewerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewerServiceImpl implements InterviewerService {


    @Override
    public Interviewer create(Long interviewId, InterviewerRequest dto) {
        return null;
    }

    @Override
    public List<Interviewer> getAllByInterviewId(Long interviewerId) {
        return null;
    }

    @Override
    public Interviewer getById(Long interviewId, Long id) {
        return null;
    }

    @Override
    public Interviewer getById(Long id) {
        return null;
    }

    @Override
    public Interviewer update(Long interviewId, Long id, InterviewerRequest dto) {
        return null;
    }

    @Override
    public void delete(Long interviewId, Long id) {

    }

    @Override
    public Interviewer save(Interviewer interviewer) {
        return null;
    }

    @Override
    public InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSession evaluationSession) {
        return null;
    }
}
