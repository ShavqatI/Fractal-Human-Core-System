package com.fractal.domain.recruitment.interview.evaluation.session;


import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.recruitment.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.InterviewEvaluationSessionAnswerSubmission;
import com.fractal.domain.recruitment.interview.interviewer.Interviewer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "evaluation_session", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterviewEvaluationSession extends ApprovalWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_id", referencedColumnName = "id")
    private InterviewEvaluation interviewEvaluation;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id", referencedColumnName = "id")
    private Interview interview;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interviewer_id", referencedColumnName = "id")
    private Interviewer interviewer;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "interviewEvaluationSession", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InterviewEvaluationSessionAnswerSubmission> submissions = new ArrayList<>();

    @Transactional
    public void addSubmission(InterviewEvaluationSessionAnswerSubmission submission) {
        if (submissions == null) submissions = new ArrayList<>();
        submission.setInterviewEvaluationSession(this);
        submissions.add(submission);
    }

    @Transactional
    public void removeSubmission(InterviewEvaluationSessionAnswerSubmission submission) {
        if (submissions != null && !submissions.isEmpty())
            submissions.remove(submission);
    }
}
