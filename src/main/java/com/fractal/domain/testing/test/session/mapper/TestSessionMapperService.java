package com.fractal.domain.testing.test.session.mapper;

import com.fractal.domain.testing.test.session.TestSession;
import com.fractal.domain.testing.test.session.dto.TestSessionRequest;
import com.fractal.domain.testing.test.session.dto.TestSessionResponse;

public interface TestSessionMapperService {
    TestSessionResponse toDTO(TestSession testSession);

    TestSession toEntity(TestSessionRequest dto);

    TestSession toEntity(TestSession testSession, TestSessionRequest dto);
}


