package com.fractal.domain.interview.evaluation.session.answer;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.interview.evaluation.session.InterviewEvaluationSession;
import com.fractal.domain.interview.evaluation.section.question.InterviewEvaluationQuestion;
import com.fractal.domain.interview.evaluation.session.answer.selected.InterviewEvaluationSessionSelectedAnswer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answer_submission", schema = "recruitment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterviewEvaluationSessionAnswerSubmission extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_session_id", nullable = false)
    private InterviewEvaluationSession interviewEvaluationSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_question_id", nullable = false)
    private InterviewEvaluationQuestion question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "interviewEvaluationSessionAnswerSubmission", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InterviewEvaluationSessionSelectedAnswer> selectedAnswers = new ArrayList<>();

    @Transactional
    public void addAnswer(InterviewEvaluationSessionSelectedAnswer selectedAnswer) {
        if (selectedAnswers == null) selectedAnswers = new ArrayList<>();
        selectedAnswer.setInterviewEvaluationSessionAnswerSubmission(this);
        selectedAnswers.add(selectedAnswer);
    }

    @Transactional
    public void removeAnswer(InterviewEvaluationSessionSelectedAnswer selectedAnswer) {
        if (selectedAnswers != null && !selectedAnswers.isEmpty())
            selectedAnswers.remove(selectedAnswer);
    }


}
