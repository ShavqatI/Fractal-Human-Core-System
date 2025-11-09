package com.fractal.domain.interview.evaluation.session.submission.selected_answer;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.interview.evaluation.section.question.answer.InterviewEvaluationAnswer;
import com.fractal.domain.interview.evaluation.session.submission.InterviewEvaluationSessionAnswerSubmission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "selected_answer", schema = "recruitment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterviewEvaluationSessionSelectedAnswer extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_answer_id", nullable = false)
    private InterviewEvaluationAnswer answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_session_answer_submission_id", nullable = false)
    private InterviewEvaluationSessionAnswerSubmission interviewEvaluationSessionAnswerSubmission;

    private LocalDateTime selectedDate;

    /*@Override
    protected void onCreate() {
        super.onCreate();
        this.selectedDate = LocalDateTime.now();

    }*/

}
