package com.fractal.domain.testing.test.session.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.testing.test.TestService;
import com.fractal.domain.testing.test.session.TestSession;
import com.fractal.domain.testing.test.session.answer.mapper.AnswerSubmissionMapperService;
import com.fractal.domain.testing.test.session.dto.TestSessionRequest;
import com.fractal.domain.testing.test.session.dto.TestSessionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class TestSessionMapperServiceImpl implements TestSessionMapperService {

    private final AnswerSubmissionMapperService submissionMapperService;
    private final TestService testService;
    private final StatusService statusService;

    @Override
    public TestSessionResponse toDTO(TestSession testSession) {
        return new TestSessionResponse(
                testSession.getId(),
                testService.toCompactDTO(testSession.getTest()),
                testSession.getStartDate(),
                testSession.getEndDate(),
                testSession.getScore(),
                Optional.ofNullable(testSession.getSubmissions())
                        .orElse(emptyList())
                        .stream()
                        .map(submissionMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(testSession.getStatus()),
                testSession.getCreatedDate()

        );
    }

    @Override
    public TestSession toEntity(TestSessionRequest dto) {
        return mapToEntity(new TestSession(), dto);
    }

    @Override
    public TestSession toEntity(TestSession testSession, TestSessionRequest dto) {
        return mapToEntity(testSession, dto);
    }

    private TestSession mapToEntity(TestSession testSession, TestSessionRequest dto) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        testSession.setTest(testService.getById(dto.testId()));
        testSession.setUser(null);
        testSession.setStartDate(dto.startDate());
        testSession.setEndDate(dto.endDate());
        testSession.setStatus(statusService.getById(dto.statusId()));
        dto.submissions().forEach(submission -> testSession.addAnswerSubmission(submissionMapperService.toEntity(submission)));
        return testSession;
    }
}
