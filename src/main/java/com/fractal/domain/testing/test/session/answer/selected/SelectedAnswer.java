package com.fractal.domain.testing.test.session.answer.selected;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.testing.question.answer.Answer;
import com.fractal.domain.testing.test.session.answer.AnswerSubmission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "selected_answer", schema = "testing_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectedAnswer extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_submission_id", nullable = false)
    private AnswerSubmission answerSubmission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    private LocalDateTime selectedDate;

}