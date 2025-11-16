package com.fractal.domain.interview.evaluation.section.question.answer;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.interview.evaluation.section.question.InterviewEvaluationQuestion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "interview_evaluation_answer", schema = "recruitment_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterviewEvaluationAnswer extends AbstractEntity {

    @Column(nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_evaluation_question_id", referencedColumnName = "id")
    private InterviewEvaluationQuestion interviewEvaluationQuestion;


}
