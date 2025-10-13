package com.fractal.domain.learning_develpment.learning.learner.mapper;

import com.fractal.domain.learning_develpment.learning.learner.Learner;
import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.ExternalLearner;
import com.fractal.domain.learning_develpment.learning.learner.external.mapper.ExternalLearnerMapperService;
import com.fractal.domain.learning_develpment.learning.learner.internal.InternalLearner;
import com.fractal.domain.learning_develpment.learning.learner.internal.mapper.InternalLearnerMapperService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LearnerMapperServiceImpl implements LearnerMapperService {

    private final InternalLearnerMapperService internalLearnerMapperService;
    private final ExternalLearnerMapperService externalLearnerMapperService;

    @Override
    public LearnerCompactResponse toCompactDTO(Learner learner) {
        learner = (Learner) Hibernate.unproxy(learner);
        if (learner instanceof InternalLearner)
            return internalLearnerMapperService.toCompactDTO((InternalLearner) learner);
        else return externalLearnerMapperService.toCompactDTO((ExternalLearner) learner);


    }

   /* @Override
    public EmploymentResponse toDTO(Learner learner) {
        if (learner instanceof InternalLearner)
            return internalLearnerMapperService.toDTO((InternalLearner) learner);
        else return externalLearnerMapperService.toDTO((ExternalLearner) learner);
    }*/

  /*  @Override
    public Employment toEntity(EmploymentRequest dto) {
        if (dto instanceof InternalEmploymentRequest)
            return internalLearnerMapperService.toEntity((InternalEmploymentRequest) dto);
        else return externalLearnerMapperService.toEntity((ExternalEmploymentRequest) dto);
    }*/
}
