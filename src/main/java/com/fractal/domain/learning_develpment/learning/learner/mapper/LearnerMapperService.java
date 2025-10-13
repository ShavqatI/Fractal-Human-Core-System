package com.fractal.domain.learning_develpment.learning.learner.mapper;

import com.fractal.domain.learning_develpment.learning.learner.Learner;
import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;

public interface LearnerMapperService {
    //EmploymentResponse toDTO(Learner learner);
    LearnerCompactResponse toCompactDTO(Learner learner);
    //Employment toEntity(EmploymentRequest dto);
}


