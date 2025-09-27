package com.fractal.domain.interview.evaluation.section;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.interview.evaluation.section.question.InterviewEvaluationQuestion;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Interview_evaluation_section", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterviewEvaluationSection extends AbstractEntity {

    @Column(name = "code",unique = true)
    protected String code;

    @Column(name = "name")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_id",referencedColumnName = "id")
    private InterviewEvaluation interviewEvaluation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private InterviewEvaluationSection parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "interviewEvaluationSection",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InterviewEvaluationQuestion> questions = new ArrayList<>();

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InterviewEvaluationSection> children = new ArrayList<>();

    @Transactional
    public void addQuestion(InterviewEvaluationQuestion question) {
        if (questions == null) questions = new ArrayList<>();
        question.setInterviewEvaluationSection(this);
        questions.add(question);
    }

    @Transactional
    public void removeQuestion(InterviewEvaluationQuestion question) {
        if (questions != null && !questions.isEmpty())
            questions.remove(question);
    }

    @Transactional
    public void addChild(InterviewEvaluationSection section) {
        if (children == null) children = new ArrayList<>();
        section.setParent(this);
        children.add(section);
    }

    @Transactional
    public void removeChild(InterviewEvaluationSection section) {
        if (children != null && !children.isEmpty())
            children.remove(section);
    }
}
