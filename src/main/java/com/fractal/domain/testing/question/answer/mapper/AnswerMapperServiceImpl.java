package com.fractal.domain.testing.question.answer.mapper;

import com.fractal.domain.testing.question.answer.Answer;
import com.fractal.domain.testing.question.answer.dto.AnswerRequest;
import com.fractal.domain.testing.question.answer.dto.AnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AnswerMapperServiceImpl implements AnswerMapperService {

    @Override
    public AnswerResponse toDTO(Answer answer) {
        return new AnswerResponse(
                answer.getId(),
                answer.getText(),
                answer.getCorrect(),
                answer.getCreatedDate()

        );
    }

    @Override
    public Answer toEntity(AnswerRequest dto) {
        return mapToEntity(new Answer(), dto);
    }

    @Override
    public Answer toEntity(Answer answer, AnswerRequest dto) {
        return mapToEntity(answer, dto);
    }

    private Answer mapToEntity(Answer answer, AnswerRequest dto) {
        answer.setText(dto.text());
        answer.setCorrect(dto.correct());
        return answer;
    }
}
