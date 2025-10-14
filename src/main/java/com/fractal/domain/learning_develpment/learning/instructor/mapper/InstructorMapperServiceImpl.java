package com.fractal.domain.learning_develpment.learning.instructor.mapper;

import com.fractal.domain.learning_develpment.learning.instructor.Instructor;
import com.fractal.domain.learning_develpment.learning.instructor.dto.InstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.ExternalInstructor;
import com.fractal.domain.learning_develpment.learning.instructor.external.mapper.ExternalInstructorMapperService;
import com.fractal.domain.learning_develpment.learning.instructor.internal.InternalInstructor;
import com.fractal.domain.learning_develpment.learning.instructor.internal.mapper.InternalInstructorMapperService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InstructorMapperServiceImpl implements InstructorMapperService {

    private final InternalInstructorMapperService internalInstructorMapperService;
    private final ExternalInstructorMapperService externalInstructorMapperService;

    @Override
    public InstructorCompactResponse toCompactDTO(Instructor instructor) {
        instructor = (Instructor) Hibernate.unproxy(instructor);
        if (instructor instanceof InternalInstructor)
            return internalInstructorMapperService.toCompactDTO((InternalInstructor) instructor);
        else return externalInstructorMapperService.toCompactDTO((ExternalInstructor) instructor);


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
