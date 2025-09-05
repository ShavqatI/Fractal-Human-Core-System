package com.fractal.domain.recruitment.interview.evaluation.session;

import com.fractal.domain.recruitment.interview.InterviewService;
import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluationService;
import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.InterviewEvaluationSessionSelectedAnswer;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.mapper.InterviewEvaluationSessionSelectedAnswerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSessionServiceImpl implements InterviewEvaluationSessionService {

    private final InterviewEvaluationSessionRepository evaluationSessionRepository;
    private final InterviewEvaluationSessionSelectedAnswerMapperService mapperService;
    private final InterviewService interviewService;


    @Override
    public InterviewEvaluationSession create(Long evaluationId, InterviewEvaluationSessionSelectedAnswerRequest dto) {
        var evaluation = interviewEvaluationService.getById(evaluationId);
        var section = mapperService.toEntity(dto);
        evaluation.addSection(section);
        interviewEvaluationService.save(evaluation);
        return section;
    }

    @Override
    public List<InterviewEvaluationSession> getAllByInterviewId(Long interviewId) {
        return evaluationSessionRepository.findAllByInterviewId(interviewId);
    }

    @Override
    public InterviewEvaluationSession getById(Long interviewId, Long id) {
       return evaluationSessionRepository.findByInterviewIdAndId(interviewId,id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session with id: " + id + " not found"));

    }

    @Override
    public InterviewEvaluationSession getById(Long id) {
        return evaluationSessionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Interview Evaluation Session with id: " + id + " not found"));
    }

    @Override
    public InterviewEvaluationSession update(Long evaluationId, Long id, InterviewEvaluationSessionSelectedAnswerRequest dto) {
        return null;
    }

    @Override
    public void delete(Long evaluationId, Long id) {

    }
    @Override
    public InterviewEvaluationSession save(InterviewEvaluationSession session) {
        try {
            return evaluationSessionRepository.save(session);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
