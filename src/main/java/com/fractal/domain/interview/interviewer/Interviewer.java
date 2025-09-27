package com.fractal.domain.interview.interviewer;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.interview.Interview;
import com.fractal.domain.interview.evaluation.session.InterviewEvaluationSession;
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
@Table(name = "interviewer", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Interviewer extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id",referencedColumnName = "id")
    private Interview interview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @Column(name = "scheduled_time", nullable = false)
    private LocalDateTime scheduledTime;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "interviewer",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InterviewEvaluationSession> evaluationSessions = new ArrayList<>();

    @Transactional
    public void addEvaluationSession(InterviewEvaluationSession evaluationSession) {
        if (evaluationSessions == null) evaluationSessions = new ArrayList<>();
        evaluationSession.setInterviewer(this);
        evaluationSessions.add(evaluationSession);
    }

    @Transactional
    public void removeEvaluationSession(InterviewEvaluationSession evaluationSession) {
        if (evaluationSessions != null && !evaluationSessions.isEmpty())
            evaluationSessions.remove(evaluationSession);
    }

}
