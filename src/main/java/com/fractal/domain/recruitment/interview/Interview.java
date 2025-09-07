package com.fractal.domain.recruitment.interview;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.domain.recruitment.interview.evaluation.session.InterviewEvaluationSession;
import com.fractal.domain.recruitment.interview.interviewee.Interviewee;
import com.fractal.domain.recruitment.interview.interviewer.Interviewer;
import com.fractal.domain.recruitment.interview.type.InterviewType;
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
@Table(name = "interview", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Interview extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_type_id",referencedColumnName = "id")
    private InterviewType interviewType;

    @Column(name = "scheduled_time", nullable = false)
    private LocalDateTime scheduledTime;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "description")
    private String description;

    @Column(name = "notes")
    private String notes;

    @Column(name = "details")
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "interview",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Interviewer> interviewers = new ArrayList<>();

    @OneToMany(mappedBy = "interview",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Interviewee> interviewees = new ArrayList<>();


    @Transactional
    public void addInterviewer(Interviewer interviewer) {
        if (interviewers == null) interviewers = new ArrayList<>();
        interviewer.setInterview(this);
        interviewers.add(interviewer);
    }

    @Transactional
    public void removeInterviewer(Interviewer interviewer) {
        if (interviewers != null && !interviewers.isEmpty())
            interviewers.remove(interviewer);
    }

    @Transactional
    public void addInterviewee(Interviewee interviewee) {
        if (interviewees == null) interviewees = new ArrayList<>();
        interviewee.setInterview(this);
        interviewees.add(interviewee);
    }

    @Transactional
    public void removeInterviewee(Interviewee interviewee) {
        if (interviewees != null && !interviewees.isEmpty())
            interviewees.remove(interviewee);
    }
}
