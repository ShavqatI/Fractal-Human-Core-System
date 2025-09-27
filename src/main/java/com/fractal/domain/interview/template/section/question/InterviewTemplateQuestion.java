package com.fractal.domain.interview.template.section.question;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.interview.template.section.InterviewTemplateSection;
import com.fractal.domain.interview.template.section.question.answer.InterviewTemplateAnswer;
import com.fractal.domain.testing.question.type.QuestionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Interview_template_question", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterviewTemplateQuestion extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_section_id", referencedColumnName = "id")
    private InterviewTemplateSection interviewTemplateSection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_type_id", referencedColumnName = "id")
    private QuestionType questionType;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "max_selectable_options")
    private Integer maxSelectableOptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "interviewEvaluationQuestion", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<InterviewTemplateAnswer> answers = new ArrayList<>();

    @Transactional
    public void addAnswer(InterviewTemplateAnswer answer) {
        if (answers == null) answers = new ArrayList<>();
        answer.setInterviewTemplateQuestion(this);
        answers.add(answer);
    }

    @Transactional
    public void removeAnswer(InterviewTemplateAnswer answer) {
        if (answers != null && !answers.isEmpty())
            answers.remove(answer);
    }

}
