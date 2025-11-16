package com.fractal.domain.testing.test.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.testing.question.mapper.QuestionMapperService;
import com.fractal.domain.testing.test.Test;
import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class TestMapperServiceImpl implements TestMapperService {

    private final QuestionMapperService questionMapperService;
    private final StatusService statusService;

    @Override
    public TestResponse toDTO(Test test) {
        return new TestResponse(
                test.getId(),
                test.getTitle(),
                test.getDescription(),
                test.getDurationMinutes(),
                Optional.ofNullable(test.getQuestions())
                        .orElse(emptyList())
                        .stream()
                        .map(questionMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(test.getStatus()),
                test.getCreatedDate()

        );
    }

    @Override
    public TestCompactResponse toCompactDTO(Test test) {
        return new TestCompactResponse(
                test.getId(),
                test.getTitle(),
                test.getDescription(),
                test.getDurationMinutes());
    }

    @Override
    public Test toEntity(TestRequest dto) {
        return mapToEntity(new Test(), dto);
    }

    @Override
    public Test toEntity(Test test, TestRequest dto) {
        return mapToEntity(test, dto);
    }

    private Test mapToEntity(Test test, TestRequest dto) {
        test.setTitle(dto.title());
        test.setDescription(dto.description());
        test.setDurationMinutes(dto.durationMinutes());
        test.setStatus(statusService.getById(dto.statusId()));
        dto.questions().forEach(question -> test.addQuestion(questionMapperService.toEntity(question)));
        return test;
    }
}
