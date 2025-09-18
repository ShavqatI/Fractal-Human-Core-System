package com.fractal.domain.testing.test.mapper;

import com.fractal.domain.testing.test.Test;
import com.fractal.domain.testing.test.dto.TestCompactResponse;
import com.fractal.domain.testing.test.dto.TestRequest;
import com.fractal.domain.testing.test.dto.TestResponse;

public interface TestMapperService {
    TestResponse toDTO(Test test);
    TestCompactResponse toCompactDTO(Test test);
    Test toEntity(TestRequest dto);
    Test toEntity(Test test, TestRequest dto);
}


