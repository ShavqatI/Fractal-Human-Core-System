package com.fractal.domain.testing.test;

import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;

import java.util.List;

public interface TestService {
    Test create(TestRequest dto);

    List<Test> getAll();

    Test getById(Long id);

    Test update(Long id, TestRequest dto);

    void deleteById(Long id);

    TestResponse toDTO(Test test);

    TestCompactResponse toCompactDTO(Test test);

    Test save(Test test);


}
