package com.fractal.domain.learning_develpment.learning.learner;

import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.mapper.LearnerMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LearnerServiceImpl implements LearnerService {

    private final LearnerRepository learnerRepository;
    private final LearnerMapperService mapperService;
    @Override
    public Learner getById(Long id) {
        return learnerRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }


    @Override
    public LearnerCompactResponse toCompactDTO(Learner learner) {
        return mapperService.toCompactDTO(learner);
    }
}
