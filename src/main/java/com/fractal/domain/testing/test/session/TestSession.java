package com.fractal.domain.testing.test.session;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.testing.test.Test;
import com.fractal.domain.testing.test.session.answer.AnswerSubmission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "test_session", schema = "testing_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestSession extends ApprovalWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    private Double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "testSession", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AnswerSubmission> submissions = new ArrayList<>();

    public void addAnswerSubmission(AnswerSubmission submission) {
        if (submissions == null) submissions = new ArrayList<>();
        submission.setTestSession(this);
        submissions.add(submission);
    }

    public void removeAnswerSubmission(AnswerSubmission submission) {
        if (submissions != null && !submissions.isEmpty())
            submissions.remove(submission);
        submission.setTestSession(null);
    }
}
