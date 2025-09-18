package com.fractal.domain.testing.test;

import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;
import com.fractal.domain.testing.test.mapper.TestMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final TestMapperService mapperService;

    @Override
    @Transactional
    public Test create(TestRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Test update(Long id, TestRequest dto) {
        try {
            Test test = mapperService.toEntity(findById(id),dto);
            return save(test);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      testRepository.delete(findById(id));
    }

    @Override
    public TestResponse toDTO(Test test) {
        return mapperService.toDTO(test);
    }

    @Override
    public TestCompactResponse toCompactDTO(Test test) {
        return mapperService.toCompactDTO(test);
    }


    @Override
    @Transactional
    public Test save(Test test) {
        try {
            return testRepository.save(test);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Test findById(Long id) {
        return testRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Test with id: " + id + " not found"));
    }
}
