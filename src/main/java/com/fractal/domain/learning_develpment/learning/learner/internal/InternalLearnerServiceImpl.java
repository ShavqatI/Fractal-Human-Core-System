package com.fractal.domain.learning_develpment.learning.learner.internal;

import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerResponse;
import com.fractal.domain.learning_develpment.learning.learner.internal.mapper.InternalLearnerMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class InternalLearnerServiceImpl implements InternalLearnerService {

    private final InternalLearnerRepository learnerRepository;
    private final InternalLearnerMapperService mapperService;

    @Override
    @Transactional
    public InternalLearner create(InternalLearnerRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<InternalLearner> getAll() {
        return learnerRepository.findAll();
    }

    @Override
    public InternalLearner getById(Long id) {
        return findById(id);
    }

    @Override
    public InternalLearner update(Long id, InternalLearnerRequest dto) {
        try {
            InternalLearner participant = mapperService.toEntity(findById(id),dto);
            return save(participant);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      learnerRepository.delete(findById(id));
    }

    @Override
    public InternalLearnerResponse toDTO(InternalLearner learner) {
        return mapperService.toDTO(learner);
    }

    @Override
    public InternalLearnerCompactResponse toCompactDTO(InternalLearner learner) {
        return mapperService.toCompactDTO(learner);
    }


    private InternalLearner save(InternalLearner trainer) {
        try {
            return learnerRepository.save(trainer);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InternalLearner findById(Long id) {
        return learnerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Internal Learner with id: " + id + " not found"));
    }
}
