package com.fractal.domain.interview.template;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.interview.template.section.InterviewTemplateSection;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "interview_tempate", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterviewTemplate extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code",unique = true)
    protected String code;

    @Column(name = "name")
    protected String name;

    @OneToMany(mappedBy = "interviewEvaluation",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InterviewTemplateSection> sections = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public void addSection(InterviewTemplateSection section) {
        if (sections == null) sections = new ArrayList<>();
        section.setInterviewTemplate(this);
        sections.add(section);
    }
    public void removeSection(InterviewTemplateSection section) {
        if (sections != null && !sections.isEmpty())
            sections.remove(section);
    }
}
