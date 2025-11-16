package com.fractal.domain.testing.test.session;

import com.fractal.domain.testing.test.session.dto.TestSessionRequest;
import com.fractal.domain.testing.test.session.dto.TestSessionResponse;
import com.fractal.domain.testing.test.session.mapper.TestSessionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class TestSessionServiceImpl implements TestSessionService {

    private final TestSessionRepository testSessionRepository;
    private final TestSessionMapperService mapperService;

    @Override
    @Transactional
    public TestSession create(TestSessionRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<TestSession> getAll() {
        return testSessionRepository.findAll();
    }

    @Override
    public TestSession getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public TestSession update(Long id, TestSessionRequest dto) {
        try {
            TestSession testSession = mapperService.toEntity(findById(id), dto);
            return save(testSession);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        testSessionRepository.delete(findById(id));
    }

    @Override
    public TestSessionResponse toDTO(TestSession testSession) {
        return mapperService.toDTO(testSession);
    }


    @Override
    @Transactional
    public TestSession save(TestSession testSession) {
        try {
            return testSessionRepository.save(testSession);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private TestSession findById(Long id) {
        return testSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Test Session with id: " + id + " not found"));
    }
}
