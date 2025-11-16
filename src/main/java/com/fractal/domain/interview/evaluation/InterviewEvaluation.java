package com.fractal.domain.interview.evaluation;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.interview.evaluation.section.InterviewEvaluationSection;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "interview_evaluation", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterviewEvaluation extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", unique = true)
    protected String code;

    @Column(name = "name")
    protected String name;

    @OneToMany(mappedBy = "interviewEvaluation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<InterviewEvaluationSection> sections = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public void addSection(InterviewEvaluationSection section) {
        if (sections == null) sections = new ArrayList<>();
        section.setInterviewEvaluation(this);
        sections.add(section);
    }

    public void removeSection(InterviewEvaluationSection section) {
        if (sections != null && !sections.isEmpty())
            sections.remove(section);
    }
}
