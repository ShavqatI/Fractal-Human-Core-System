package com.fractal.domain.testing.test.session;

import com.fractal.domain.testing.test.session.dto.TestSessionRequest;
import com.fractal.domain.testing.test.session.dto.TestSessionResponse;

import java.util.List;

public interface TestSessionService {
    TestSession create(TestSessionRequest dto);
    List<TestSession> getAll();
    TestSession getById(Long id);
    TestSession update(Long id, TestSessionRequest dto);
    void deleteById(Long id);
    TestSessionResponse toDTO(TestSession testSession);
    TestSession save(TestSession testSession);


}
